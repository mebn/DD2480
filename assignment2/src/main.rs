//! # Assignment 2
//! This is a CI server that listens for webhooks from GitHub and runs a CI pipeline on the repository.

#![warn(missing_docs)]

use axum::{routing::post, Router};

pub mod ci;
pub mod github;
pub mod repository;
pub mod routes;

use routes::github_webhook::github_webhook;

// const REPO_PATH: &str = "/tmp/repo";
// const LOG_PATH: &str = "/tmp/repo";

#[tokio::main]
async fn main() {
    let app = Router::new().route("/github_webhook", post(github_webhook));

    let listener = tokio::net::TcpListener::bind("0.0.0.0:8007").await.unwrap();
    println!("Listening on {}", listener.local_addr().unwrap());
    axum::serve(listener, app).await.unwrap();
}
