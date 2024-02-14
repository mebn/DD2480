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
use routes::frontend::{list_all_commits, list_log_files_for_commit, show_file};
use routes::github_webhook::github_webhook;
use tower_http::services::ServeDir;

/// The path to the directory where the logs are stored.
const LOGS_PATH: &str = "CI_LOGS";

/// The path to the directory where the repositories are cloned.
const REPO_PATH: &str = "CI_REPOS";

/// The URL and port of the server.
const SERVER_URL: &str = "http://37.27.20.70:8007";

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
        .route("/favicon.ico", get(|| async { StatusCode::NOT_FOUND }))
        .nest_service("/docs", ServeDir::new("target/doc/assignment2"));

    let listener = tokio::net::TcpListener::bind("0.0.0.0:8007").await.unwrap();
    println!("Listening on {}", listener.local_addr().unwrap());
    axum::serve(listener, app).await.unwrap();
}
