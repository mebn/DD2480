//! A module for handling everything related to GitHub.

use std::collections::HashSet;

use serde::Deserialize;

use std::env;

// use crate::ci::Status;

#[derive(Deserialize)]
struct WebhookData {
    r#ref: String, // have to use r#ref because ref is a reserved keyword
    after: String,
    repository: Repository,
    head_commit: HeadCommit,
}

#[derive(Deserialize)]
struct Repository {
    ssh_url: String,
    clone_url: String,
}

#[derive(Deserialize)]
struct HeadCommit {
    added: Vec<String>,
    removed: Vec<String>,
    modified: Vec<String>,
}

/// A struct that contains the data from a Github webhook.
/// This relates to actions involving GitHub, e.g. sending a commit status.
pub struct Github {
    webhook_data: WebhookData,
}

impl Github {
    /// Create a new Github object from the webhook data.
    ///
    /// If the webhook data is not valid JSON or have the correct structure, an error is returned.
    pub fn new(data: &str) -> Result<Github, String> {
        let webhook_data: WebhookData = match serde_json::from_str(data) {
            Ok(data) => data,
            Err(e) => return Err(e.to_string()),
        };

        Ok(Github { webhook_data })
    }

    /// Used to get the branch name from the webhook data related to a push event.
    pub fn get_branch(&self) -> String {
        let branch = self.webhook_data.r#ref.clone(); // "refs/heads/issue/123"
        let branch = &branch["refs/heads/".len()..]; // "issue/123"
        branch.to_string()
    }

    /// Used to get the commit id from the webhook data related to a push event.
    ///
    /// This is the commit id of the last commit in the push event. Not the same as the branch.
    pub fn get_commit_id(&self) -> String {
        self.webhook_data.after.clone()
    }

    /// Used to get the ssh url of the repository from the webhook data.
    ///
    /// This is the url that can be used to clone the repository using ssh.
    pub fn get_ssh_url(&self) -> String {
        self.webhook_data.repository.ssh_url.clone()
    }

    /// Used to get the clone url of the repository from the webhook data.
    ///
    /// This is the url that can be used to clone the repository using https.
    ///
    /// This can also be used to get the url of the repository on github.
    pub fn get_clone_url(&self) -> String {
        self.webhook_data.repository.clone_url.clone()
    }

    /// Used to get the top level folders that a webhook concerns.
    ///
    /// This can be used to determine which assignments have been modified,
    /// and thus which commands to run in the CI.
    ///
    /// E.g. if `assignment1/src/main.rs` is modified, this function will return `vec!["assignment1"]`.
    pub fn get_modified_folders(&self) -> Vec<String> {
        let mut modified_folders = HashSet::new();

        let catagories = [
            self.webhook_data.head_commit.added.iter(),
            self.webhook_data.head_commit.removed.iter(),
            self.webhook_data.head_commit.modified.iter(),
        ];

        for catagory in catagories {
            for file in catagory {
                let folder = file.split('/').next().unwrap();
                if folder.contains("assignment") {
                    modified_folders.insert(folder.to_string());
                } else {
                    // if the file is not in an assignment folder, it is in the root of the repository
                    modified_folders.insert("/".to_string());
                }
            }
        }

        modified_folders.into_iter().collect()
    }

    /// Sends the status of the commit to GitHub.
    ///
    /// This method sends a POST request to the GitHub API to update the status of the commit.
    ///
    /// The method uses the `GITHUB_TOKEN` environment variable for authentication.
    /// The owner and repository are currently hardcoded to "mebn" and "DD2480", respectively.
    ///
    /// # Arguments
    ///
    /// * `commit_status` - status of CI process (success/failure)
    ///
    pub async fn send_commit_status(&self, commit_status: &str) {
        let token = format!(
            "Bearer {}",
            env::var("GITHUB_TOKEN").expect("Could not find GITHUB_TOKEN")
        );
        let sha = self.get_commit_id();

        // Body
        let target_url = format!("{}/{}", "http://37.27.20.70:8007", sha);
        let description = format!("Build & Test: {}", commit_status);
        let body = format!(
            "{{\"state\": \"{}\", \"target_url\": \"{}\", \"description\": \"{}\"}}",
            commit_status, target_url, description
        );

        // Request URL
        let owner = "mebn";
        let repo = "DD2480";
        let url = format!(
            "https://api.github.com/repos/{}/{}/statuses/{}",
            owner, repo, sha
        );

        let client = reqwest::Client::new();

        let res = client
            .post(&url)
            .header("Accept", "application/vnd.github+json")
            .header("Authorization", token)
            .header("User-Agent", "CI-Server")
            .body(body)
            .send()
            .await;

        match res {
            Ok(res) => {
                if res.status().is_success() {
                    println!(
                        "Successfully sent commit status {} to GitHub for commit {}",
                        commit_status, sha
                    );
                } else {
                    println!(
                        "Failed to send commit status {} to GitHub for commit {}",
                        commit_status, sha
                    );
                }
            }
            Err(e) => {
                panic!(
                    "Error sending commit status to github for commit {}: {}",
                    sha, e
                );
            }
        }
        // println!("{:?}", res);
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    fn real_data() -> String {
        r#"{"ref": "refs/heads/issue/123", "after": "955c2d172c3b5ac2f125121b8e6c3f99fd560966",
            "repository": {"ssh_url": "git@github.com:mebn/DD2480.git", "clone_url": "https://github.com/mebn/DD2480.git"},
            "head_commit": { "added": ["assignment2/src/routes/github_webhook.rs", "assignment2/src/routes/mod.rs"],
                "removed": ["README.md"], "modified": []
            }
        }"#.to_string()
    }

    fn wrong_data() -> String {
        r#"{"some key": "some value"}"#.to_string()
    }

    #[test]
    /// Test that the function returns only works with valid JSON.
    fn test_new_fail() {
        let data = wrong_data();
        let github = Github::new(&data);
        assert!(github.is_err());
    }

    #[test]
    /// Test that the function returns the correct branch.
    fn test_get_branch() {
        let data = real_data();
        let github = Github::new(&data).unwrap();
        assert_eq!(github.get_branch(), "issue/123");
    }

    #[test]
    /// Test that the function returns the correct folders given added/removed/modified files.
    fn test_get_modified_folders_ok() {
        let data = real_data();
        let github = Github::new(&data).unwrap();

        let mut modified_folders = github.get_modified_folders();
        modified_folders.sort();
        let mut expected = vec!["assignment2", "/"];
        expected.sort();

        assert_eq!(modified_folders, expected);
    }
}
