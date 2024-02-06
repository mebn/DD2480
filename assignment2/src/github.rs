//! A module for handling everything related to GitHub.

use serde::Deserialize;

// use crate::ci::Status;

#[derive(Deserialize)]
struct WebhookData {
    r#ref: String, // have to use r#ref because ref is a reserved keyword
    after: String,
    repository: Repository,
}

#[derive(Deserialize)]
struct Repository {
    ssh_url: String,
    clone_url: String,
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

    // pub fn send_commit_status(&self, status: &Status) {}
}

#[cfg(test)]
mod tests {
    use super::*;

    fn real_data() -> String {
        r#"{"ref": "refs/heads/issue/123", "after": "955c2d172c3b5ac2f125121b8e6c3f99fd560966",
            "repository": {"ssh_url": "git@github.com:mebn/DD2480.git", "clone_url": "https://github.com/mebn/DD2480.git"}}"#.to_string()
    }

    fn wrong_data() -> String {
        r#"{"some key": "some value"}"#.to_string()
    }

    #[test]
    fn test_new_fail() {
        let data = wrong_data();
        let github = Github::new(&data);
        assert!(github.is_err());
    }

    #[test]
    fn test_get_branch() {
        let data = real_data();
        let github = Github::new(&data).unwrap();
        assert_eq!(github.get_branch(), "issue/123");
    }
}
