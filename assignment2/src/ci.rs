pub struct CI {
    path_repo: String, // DD2480/assignment2/temp/repo-1322
    path_log: String, // DD2480/assignment2/logs/repo-1322
    status: Status
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
            }
        }
    }
    pub fn build(&self) {}
    pub fn test(&self) {}
}
