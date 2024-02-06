use git2::Repository;

pub struct Repo {
    url: String,
    path: String, // Path to local repo
    branch: String,
    commit_id: String,
}

impl Repo {
    pub fn new(url: String, path: String, branch: String, commit_id: String) -> Self {
        Self {
            url,
            path,
            branch,
            commit_id,
        }
    }
    pub fn clone(&self) {
        println!("Cloning repo from {} to {}", self.url, self.path);
        let repo = match Repository::clone(&self.url, &self.path) {
            Ok(repo) => repo,
            Err(e) => panic!("failed to clone: {}", e),
        };
    }
    pub fn checkout(&self) {}
    pub fn cleanup(&self) {}
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_clone() {
        assert!(true);
    }
}
