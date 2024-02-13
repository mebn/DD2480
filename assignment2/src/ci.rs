//! This module implements a simple Continuous Integration (CI) system.
//! It provides functionality to build and test local repositories.

use std::{fs::File, io::Write, process::Command};

pub struct CI {
    path_repo: String, // DD2480/assignment2/temp/repo-1322
    path_log: String,  // DD2480/assignment2/logs/repo-1322
    status: CommitStatus,
}

/// Struct to define the different statuses
#[derive(PartialEq, Debug)]
pub enum Status {
    Pending,
    Success,
    Failure,
}

/// Struct to hold the status of the build and test processes.
pub struct CommitStatus {
    build_status: Status,
    test_status: Status,
}
impl CommitStatus {
    /// Returns the overall status of the build & test as a String.
    ///
    /// The overall status is determined by the build and test statuses.
    /// If either status is `Failure`, the overall status is `Failure`.
    /// If either status is `Pending` and none is `Failure`, the overall status is `Pending`.
    /// If both statuses are `Success`, the overall status is `Success`.
    pub fn total_status(&self) -> String {
        match (&self.build_status, &self.test_status) {
            (Status::Failure, _) | (_, Status::Failure) => "failure".to_string(),
            (Status::Pending, _) | (_, Status::Pending) => "pending".to_string(),
            _ => "success".to_string(),
        }
    }
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
            status: CommitStatus {
                build_status: Status::Pending,
                test_status: Status::Pending,
            },
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

    /// Returns a reference to the `CommitStatus` struct.
    pub fn get_status(&self) -> &CommitStatus {
        &self.status
    }

    /// Runs `cargo test --verbose` on the repo specified in `self.path_repo`,
    /// updates the test status in `self.status`,
    /// and logs the test output to the directory specified by `self.path_log`.
    pub fn test(&mut self) -> Result<(), std::io::Error> {
        let output = Command::new("cargo")
            .arg("test")
            .arg("--verbose")
            .current_dir(&self.path_repo)
            .output()?;

        if output.status.success() {
            println!("Tests for {} passed successfully", self.path_repo);
            self.status.test_status = Status::Success; // Personally not the biggest fan of updating the value inside the instance. Maybe return the status code instead?
        } else {
            println!("Tests for {} failed", self.path_repo);
            self.status.test_status = Status::Failure;
        }
        self.log_to_file(&output.stdout, "test.log".to_string())?;

        Ok(())
    }

    /// Logs the bytes to a file.
    ///
    /// # Arguments
    ///
    /// * `bytes` - The data to be written to the file.
    /// * `filename` - The name of the file in the `self.path_log` directory.
    fn log_to_file(&self, bytes: &[u8], filename: String) -> Result<(), std::io::Error> {
        std::fs::create_dir_all(&self.path_log)?;
        File::create(format!("{}/{}", self.path_log, filename))?.write_all(&bytes)?;
        Ok(())
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
        let path_repo = "tests/libs/commit-pass".to_string();
        let log_repo = "tests/logs/commit-pass".to_string();
        let mut ci = CI::new(path_repo.clone(), log_repo.clone());
        ci.test().unwrap();

        assert!(std::path::Path::new(&(log_repo.clone() + "/test.log")).exists());
        std::fs::remove_dir_all(log_repo.clone()).unwrap();

        assert_eq!(ci.status.test_status, Status::Success);
    }

    /// Tests that a failing test suite updates the `test_status` field in `Status` to `false`
    /// and logs the test output to a file.
    #[test]
    fn test_ci_tests_fail() {
        let path_repo = "tests/libs/commit-fail".to_string();
        let log_repo = "tests/logs/commit-fail".to_string();
        let mut ci = CI::new(path_repo.clone(), log_repo.clone());
        ci.test().unwrap();

        assert!(std::path::Path::new(&(log_repo.clone() + "/test.log")).exists());
        std::fs::remove_dir_all(log_repo.clone()).unwrap();

        assert_eq!(ci.status.test_status, Status::Failure);
    }


    /// Tests that a successful build returns true and logs stdout to a file
    #[test]
    fn test_ci_build_pass() {
        let path_repo = "tests/libs/build-pass".to_string();
        let log_repo = "tests/logs/build-pass".to_string();
        let mut ci = CI::new(path_repo.clone(), log_repo.clone());
        ci.test().unwrap();

        assert!(std::path::Path::new(&(log_repo.clone())).exists());
        std::fs::remove_dir_all(log_repo.clone()).unwrap();

        assert_eq!(ci.build(), true);
    }

    /// Tests that a failed build returns false and logs stdout to a file
    #[test]
    fn test_ci_build_fail() {
        let path_repo = "tests/libs/build-fail".to_string();
        let log_repo = "tests/logs/build-fail".to_string();
        let mut ci = CI::new(path_repo.clone(), log_repo.clone());
        ci.test().unwrap();

        assert!(std::path::Path::new(&(log_repo.clone())).exists());
        std::fs::remove_dir_all(log_repo.clone()).unwrap();

        assert_eq!(ci.build(), false);
    }

    #[test]
    fn test_total_status() {
        let mut ci = CI::new("test/directory".to_string(), "test/directory".to_string());
        assert_eq!(ci.status.total_status(), "pending");

        ci.status.build_status = Status::Success;
        assert_eq!(ci.status.total_status(), "pending");

        ci.status.test_status = Status::Success;
        assert_eq!(ci.status.total_status(), "success");

        ci.status.build_status = Status::Failure;
        assert_eq!(ci.status.total_status(), "failure");

        ci.status.test_status = Status::Pending;
        assert_eq!(ci.status.total_status(), "failure");
    }
}
