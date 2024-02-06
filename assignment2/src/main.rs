//! # Assignment 2
//! This is a CI server that listens for webhooks from GitHub and runs a CI/CD pipeline on the repository.

#![warn(missing_docs)]

use axum::{
    http::{HeaderMap, StatusCode},
    routing::post,
    Json, Router,
};

pub mod ci;
pub mod github;
pub mod repository;

// const REPO_PATH: &str = "/tmp/repo";
// const LOG_PATH: &str = "/tmp/repo";

#[tokio::main]
async fn main() {
    let app = Router::new().route("/handle_github_webhook", post(handle_github_webhook));

    let listener = tokio::net::TcpListener::bind("0.0.0.0:8007").await.unwrap();
    println!("Listening on {}", listener.local_addr().unwrap());
    axum::serve(listener, app).await.unwrap();
}

/// Handles the GitHub webhook.
/// Does different things depending on the event type.
/// E.g. if the event is a pull request, it will run the CI/CD pipeline.
async fn handle_github_webhook(headers: HeaderMap, body: String) -> StatusCode {
    println!("{:?}", headers);
    println!("{:?}", body);

    let github_event = headers.get("x-github-event");

    if let None = github_event {
        return StatusCode::BAD_REQUEST;
    }

    let github_event = github_event.unwrap().to_str().unwrap();

    if github_event == "pull request" {
        println!("Pull request event");
        return StatusCode::OK;
    }

    StatusCode::OK
}

// new github struct
// parse webhook
// new repo struct (url: github.webhook_data.url)
// repo.clone
// repo.checkout
// new CI struct(REPO_PATH + repo.commitID, LOG_PATH)
// CI.build()
// CI.test()
// repo.cleanup()
// github.send_commit_status(CI.status)
