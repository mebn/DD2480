//! Routes for handling GitHub webhooks.
use crate::{ci::CI, github::Github, LOGS_PATH, REPO_PATH};
use axum::http::{HeaderMap, StatusCode};
use chrono::{DateTime, Utc};
use std::{
    fs::{create_dir_all, remove_dir_all},
    process::Command,
};

/// Handles the GitHub webhook.
/// Does different things depending on the event type.
///
/// E.g. if the event is a push, it will run the CI pipeline.
/// 
pub async fn github_webhook(headers: HeaderMap, body: String) -> StatusCode {
    println!("{:?}", headers);
    println!("{:?}", body);

    let github_event = match headers.get("x-github-event") {
        Some(event) => event.to_str().unwrap(),
        None => return StatusCode::BAD_REQUEST,
    };
    if github_event == "push" {
        println!("push event, CI in progress...");
        let now = std::time::Instant::now();

        // parse github webhook data
        let github = match Github::new(&body) {
            Ok(github) => github,
            Err(e) => {
                println!("error: {e}");
                return StatusCode::INTERNAL_SERVER_ERROR;
            }
        };

        let current_date_time: DateTime<Utc> = Utc::now();
        let formatted_now = current_date_time.format("%Y-%m-%dT%H-%M-%S").to_string();

        let commit_folder = format!("commit-{}-{}", formatted_now, github.get_commit_id());
        let repo_path = format!("{}/{}", REPO_PATH, &commit_folder);

        create_dir_all(&repo_path).unwrap();

        // clone the repo
        Command::new("git")
            .args(["clone", &github.get_clone_url(), &repo_path])
            .output()
            .unwrap();

        // checkout to commit
        Command::new("git")
            .args(["checkout", &github.get_commit_id()])
            .current_dir(&repo_path)
            .output()
            .unwrap();

        // cleanup
        if let Err(e) = remove_dir_all(&repo_path) {
            println!("Error {e}");
        }

        let elapsed = now.elapsed();
        println!("CI complete, took {} seconds.", elapsed.as_secs());

        return StatusCode::OK;
    }
    StatusCode::NOT_IMPLEMENTED

}
#[cfg(test)]
mod tests {
    use super::*;

    #[tokio::test]
    /// Should return a 200 OK status code
    /// when the GitHub event is push.
    async fn test_github_webhook_ok() {
        let mut headers = HeaderMap::new();
        headers.insert("x-github-event", "push".parse().unwrap());

        let status = github_webhook(headers, "".into()).await;
        assert_eq!(status, StatusCode::OK);
    }

    #[tokio::test]
    /// Should return a 400 Bad Request status code
    /// when x-github-event is missing.
    async fn test_github_webhook_bad_request() {
        let mut headers = HeaderMap::new();
        headers.insert("this-header-does-not-exist", "push".parse().unwrap());

        let status = github_webhook(headers, "".into()).await;
        assert_eq!(status, StatusCode::BAD_REQUEST);
    }

    #[tokio::test]
    /// Should return a 501 Not Implemented status code
    /// when the event type is not recognized/handled.
    async fn test_github_webhook_not_implemented() {
        let mut headers = HeaderMap::new();
        headers.insert("x-github-event", "not-implemented".parse().unwrap());

        let status = github_webhook(headers, "".into()).await;
        assert_eq!(status, StatusCode::NOT_IMPLEMENTED);
    }
}
