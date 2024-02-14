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

            // let slash = if folder.is_empty() { "" } else { "/" };

            links.push(format!(
                "<a href='{folder}/{file_name}'>{file_name}</a><br/>",
            ));
        }
    }

    links.sort_unstable();
    let links_html = links.join("");

    format!("<html><body>{links_html}</body></html>")
}

/// Lists all the folders in the LOGS directory. Each folder is a commit.
pub async fn list_all_commits() -> Html<String> {
    let output = list_files(None, PathBuf::from(LOGS_PATH));
    Html(output)
}

/// Lists all the files in a commit. Two files for each commit: test.log and build.log.
pub async fn list_log_files_for_commit(Path(commit): Path<String>) -> Html<String> {
    let output = list_files(Some(commit), PathBuf::from(LOGS_PATH));
    Html(output)
}

/// Displays the contents of a file directly in the web browser.
pub async fn show_file(Path((commit, file)): Path<(String, String)>) -> Html<String> {
    let path = PathBuf::from(LOGS_PATH).join(&commit).join(&file);
    let contents = std::fs::read_to_string(path).unwrap();
    Html(contents)
}

#[cfg(test)]
mod tests {
    use super::*;

    fn get_path() -> PathBuf {
        PathBuf::from("tests/logs_frontend")
    }

    /// Makes sure all commits are listed.
    #[test]
    fn test_list_all_commits() {
        let response = list_files(None, get_path());
        assert_eq!(response, "<html><body><a href='/commit-1'>commit-1</a><br/><a href='/commit-2'>commit-2</a><br/></body></html>");
    }

    /// Makes sure all files for a commit are listed.
    #[test]
    fn test_list_log_files_for_commit() {
        let response = list_files(Some("commit-1".to_string()), get_path());
        assert_eq!(response, "<html><body><a href='commit-1/build.log'>build.log</a><br/><a href='commit-1/test.log'>test.log</a><br/></body></html>");
    }

    /// No logs found.
    #[test]
    fn test_list_log_files_for_commit_no_logs() {
        let response = list_files(Some("commit-1".to_string()), PathBuf::new());
        assert_eq!(response, "<html><body>no logs found</html></body>");
    }
}
