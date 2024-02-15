//! This module implements a simple Continuous Integration (CI) system.
//! It provides functionality to build and test local repositories.

use std::{fs::File, io::Write, process::Command};

/// A struct that contains the data from a CI system.
#[derive(Clone)]
pub struct CI {
    path_repo: String,
    path_log: String,
}

impl CI {
    /// Constructs a new `CI` instance. Used to run
    /// build and test processes on a local repository
    /// and log the results to file.
    ///
    /// # Arguments
    ///
    /// * `path_repo` - A string that holds the path to the local repository.
    /// * `path_log` - A string that holds the path to where the test should be logged.
    pub fn new(path_repo: String, path_log: String) -> Self {
        Self {
            path_repo,
            path_log,
        }
    }

    /// Runs `cargo build --message-fmt json` on the repo specified in `self.path_repo`
    /// Logs the stdout of the build command to directory specified in `self.path_log`
    /// Returns the build status
    pub fn build(&self) -> bool {
        let output = Command::new("cargo")
            .args(["build", "--message-format", "json"])
            .current_dir(&self.path_repo)
            .output()
            .unwrap();

        println!("Build success: {}", output.status.success());

        std::fs::create_dir_all(&self.path_log).unwrap();
        File::create(format!("{}/{}", self.path_log, "build.log"))
            .unwrap()
            .write_all(&output.stdout)
            .unwrap();

        output.status.success()
    }

    /// Runs `cargo test --verbose` on the repo specified in `self.path_repo`,
    /// updates the test status in `self.status`,
    /// and logs the test output to the directory specified by `self.path_log`.
    pub fn test(&mut self) -> bool {
        let output = Command::new("cargo")
            .args(["test", "--verbose"])
            .current_dir(&self.path_repo)
            .output()
            .unwrap();

        println!("Test success: {}", output.status.success());

        std::fs::create_dir_all(&self.path_log).unwrap();
        File::create(format!("{}/{}", self.path_log, "test.log"))
            .unwrap()
            .write_all(&output.stdout)
            .unwrap();

        output.status.success()
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    /// Tests that the `CI` struct is constructed correctly.
    #[test]
    fn test_ci_fields() {
        let ci = CI::new("test/directory".to_string(), "test/directory".to_string());
        assert_eq!(ci.path_repo, "test/directory");
        assert_eq!(ci.path_log, "test/directory");
    }

    /// Tests that a passing test suite updates the `test_status` field in `Status` to `true`
    /// and logs the test output to a file.
    #[test]
    fn test_ci_tests_pass() {
        let path_repo = "tests/libs/test-pass".to_string();
        let log_repo = "tests/logs/test-pass".to_string();
        let mut ci = CI::new(path_repo.clone(), log_repo.clone());

        let status = ci.test();
        assert!(std::path::Path::new(&(log_repo.clone() + "/test.log")).exists());
        std::fs::remove_dir_all(log_repo.clone()).unwrap();

        assert_eq!(status, true);
    }

    /// Tests that a failing test suite updates the `test_status` field in `Status` to `false`
    /// and logs the test output to a file.
    #[test]
    fn test_ci_tests_fail() {
        let path_repo = "tests/libs/test-fail".to_string();
        let log_repo = "tests/logs/test-fail".to_string();
        let mut ci = CI::new(path_repo.clone(), log_repo.clone());

        let status = ci.test();
        assert!(std::path::Path::new(&(log_repo.clone() + "/test.log")).exists());
        std::fs::remove_dir_all(log_repo.clone()).unwrap();

        assert_eq!(status, false);
    }

    /// Tests that a successful build returns true and logs stdout to a file
    #[test]
    fn test_ci_build_pass() {
        let path_repo = "tests/libs/build-pass".to_string();
        let log_repo = "tests/logs/build-pass".to_string();
        let ci = CI::new(path_repo.clone(), log_repo.clone());

        let status = ci.build();
        assert!(std::path::Path::new(&(log_repo.clone())).exists());
        std::fs::remove_dir_all(log_repo.clone()).unwrap();

        assert_eq!(status, true);
    }

    /// Tests that a failed build returns false and logs stdout to a file
    #[test]
    fn test_ci_build_fail() {
        let path_repo = "tests/libs/build-fail".to_string();
        let log_repo = "tests/logs/build-fail".to_string();
        let ci = CI::new(path_repo.clone(), log_repo.clone());

        let status = ci.build();
        assert!(std::path::Path::new(&(log_repo.clone())).exists());
        std::fs::remove_dir_all(log_repo.clone()).unwrap();

        assert_eq!(status, false);
    }
}
