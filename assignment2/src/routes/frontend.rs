//! This module contains the routes for the frontend of the CI server.

use crate::LOGS_PATH;
use axum::{extract::Path, response::Html};
use std::path::PathBuf;

/// Lists all the files in a directory.
fn list_files(commit_folder: Option<String>, mut path: PathBuf) -> String {
    // If a commit folder is provided, then we want to list the files in that folder.
    if let Some(folder) = &commit_folder {
        path = path.join(folder);
    }

    // If the directory does not exist, then there are no logs to display.
    let entries = match std::fs::read_dir(&path) {
        Ok(entries) => entries,
        Err(_) => return String::from("<html><body>no logs found</html></body>"),
    };

    let mut links = Vec::new();

    // Create a link for each file in the directory.
    for entry in entries {
        if let Ok(entry) = entry {
            let file_name = entry.file_name().into_string().unwrap();

            let folder = match &commit_folder {
                Some(commit) => commit,
                None => "",
            };

            links.push(format!(
                "<a href='{folder}/{file_name}'>{file_name}</a><br/>"
            ));
        }
    }

    links.sort_unstable();
    let links_html = links.join("");

    format!("<html><body>{links_html}</body></html>")
}

/// Lists all the folders in the LOGS directory. Each folder is a commit.
pub async fn list_all_commits() -> Html<String> {
    let output = list_files(None, LOGS_PATH.clone());
    Html(output)
}

/// Lists all the files in a commit. Two files for each commit: test.log and build.log.
pub async fn list_log_files_for_commit(Path(commit): Path<String>) -> Html<String> {
    let output = list_files(Some(commit), LOGS_PATH.clone());
    Html(output)
}

/// Displays the contents of a file directly in the web browser.
pub async fn show_file(Path((commit, file)): Path<(String, String)>) -> Html<String> {
    let path = LOGS_PATH.clone().join(&commit).join(&file);
    let contents = std::fs::read_to_string(path).unwrap();
    Html(contents)
}

#[cfg(test)]
mod tests {
    // had to use tokio, otherwise the tests would fail
    use tokio::fs::{create_dir_all, remove_dir_all, write};

    use super::*;

    fn get_path() -> PathBuf {
        std::env::current_dir().unwrap().join("tests").join("logs")
    }

    async fn setup() {
        let path = get_path();
        let commit_1 = path.clone().join("commit-1");
        let commit_2 = path.clone().join("commit-2");

        let _ = create_dir_all(path.clone()).await;
        let _ = create_dir_all(commit_1.clone()).await;
        let _ = create_dir_all(commit_2.clone()).await;

        let _ = write(commit_1.clone().join("test.log"), "test1 log").await;
        let _ = write(commit_1.clone().join("build.log"), "build1 log").await;

        let _ = write(commit_2.clone().join("test.log"), "test2 log").await;
        let _ = write(commit_2.clone().join("build.log"), "build2 log").await;
    }

    async fn teardown() {
        let path = get_path();
        let _ = remove_dir_all(path).await;
    }

    /// Makes sure all commits are listed.
    #[tokio::test]
    async fn test_list_all_commits() {
        let _ = setup().await;
        let response = list_files(None, get_path());
        let _ = teardown().await;
        assert_eq!(response, "<html><body><a href='/commit-1'>commit-1</a><br/><a href='/commit-2'>commit-2</a><br/></body></html>");
    }

    /// Makes sure all files for a commit are listed.
    #[tokio::test]
    async fn test_list_log_files_for_commit() {
        let _ = setup().await;
        let response = list_files(Some("commit-1".to_string()), get_path());
        let _ = teardown().await;
        assert_eq!(response, "<html><body><a href='commit-1/build.log'>build.log</a><br/><a href='commit-1/test.log'>test.log</a><br/></body></html>");
    }

    /// No logs found.
    #[tokio::test]
    async fn test_list_log_files_for_commit_no_logs() {
        let response = list_files(Some("commit-1".to_string()), PathBuf::new());
        assert_eq!(response, "<html><body>no logs found</html></body>");
    }
}
