//! # Assignment 2
//! This is a CI server that listens for webhooks from GitHub and runs a CI pipeline on the repository.

#![warn(missing_docs)]

pub mod ci;
pub mod github;
pub mod repository;
pub mod routes;

use axum::{
    http::StatusCode,
    routing::{get, post},
    Router,
};
use dotenv::dotenv;
use lazy_static::lazy_static;
use routes::frontend::{list_all_commits, list_log_files_for_commit, show_file};
use routes::github_webhook::github_webhook;

// Global variables to paths.
// Cannot use const because of std::env::current_dir().
// Not ideal, but it works for now.
lazy_static! {
    /// The path to the directory where the logs are stored.
    pub static ref LOGS_PATH: std::path::PathBuf = std::env::current_dir()
        .unwrap().join("CI_LOGS");

    /// The path to the directory where the repositories are cloned.
    pub static ref REPO_PATH: std::path::PathBuf = std::env::current_dir()
        .unwrap().join("CI_REPOS");
}

/// Starts the CI server and handles all the routes.
#[tokio::main]
async fn main() {
    dotenv().ok();
    let app = Router::new()
        .route("/github_webhook", post(github_webhook))
        .route("/", get(list_all_commits))
        .route("/:commit", get(list_log_files_for_commit))
        .route("/:commit/:file", get(show_file))
        // we just ignore favicon for now
        .route("/favicon.ico", get(|| async { StatusCode::NOT_FOUND }));

    let listener = tokio::net::TcpListener::bind("0.0.0.0:8007").await.unwrap();
    println!("Listening on {}", listener.local_addr().unwrap());
    axum::serve(listener, app).await.unwrap();
}
