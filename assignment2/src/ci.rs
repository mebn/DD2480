use std::{fs::File, io::Write, process::Command};

pub struct CI {
    path_repo: String, // DD2480/assignment2/temp/repo-1322
    path_log: String,  // DD2480/assignment2/logs/repo-1322
    status: Status,
}

pub struct Status {
    build_status: bool,
    test_status: bool,
}

impl CI {
    pub fn new(path_repo: String, path_log: String) -> Self {
        Self {
            path_repo,
            path_log,
            status: Status {
                build_status: false,
                test_status: false,
            },
        }
    }
    pub fn build(&self) {}

    pub fn test(&mut self) -> Result<(), std::io::Error> {
        let output = Command::new("cargo")
            .arg("test")
            .current_dir(&self.path_repo)
            .output()?;

        if output.status.success() {
            println!("Tests passed successfully");
            self.status.test_status = true; // Personally not the biggest fan of updating the value inside the instance.
        } else {
            println!("Tests failed");
        }
        self.log_to_file(&output.stdout)?;

        Ok(())
    }

    fn log_to_file(&self, bytes: &[u8]) -> Result<(), std::io::Error> {
        let mut file = File::create(&self.path_log)?;
        file.write_all(&bytes)?;
        Ok(())
    }
}
