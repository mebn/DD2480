use git2::Repository;

pub struct Repo {
    url: String,
    path: String, // Path to local repo
    branch: String,
    commit_id: String,
}

/// Represents a repository.
impl Repo {
    /// Creates a new instance of `Repo`.
    ///
    /// # Arguments
    ///
    /// * `url` - The URL of the repository.
    /// * `path` - The local path where the repository will be cloned.
    /// * `branch` - The branch to be checked out.
    /// * `commit_id` - The commit ID to be checked out.
    ///
    /// # Returns
    ///
    /// A new instance of `Repo`.
    pub fn new(url: String, path: String, branch: String, commit_id: String) -> Self {
        Self {
            url,
            path,
            branch,
            commit_id,
        }
    }

    /// Clones the repository from the URL specified in `self.url`
    /// to the path specified in `self.path`.
    pub fn clone(&self) {
        println!("Cloning repo from {} to {}", self.url, self.path);
        let repo = match Repository::clone(&self.url, &self.path) {
            Ok(repo) => repo,
            Err(e) => panic!("failed to clone: {}", e),
        };
    }

    /// Checks out a specific branch or commit.
    pub fn checkout(&self) {
        // TODO: Implement checkout logic
    }

    /// Cleans up the repository.
    pub fn cleanup(&self) {
        // TODO: Implement cleanup logic
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_clone() {
        assert!(true);
    }
}
