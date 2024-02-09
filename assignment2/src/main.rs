//! # Assignment 2
//! This is a CI server that listens for webhooks from GitHub and runs a CI pipeline on the repository.

#![warn(missing_docs)]

use axum::{routing::post, Router};

pub mod ci;
pub mod github;
pub mod repository;
pub mod routes;

use lazy_static::lazy_static;
use routes::github_webhook::github_webhook;

// Global variables to paths.
// Cannot use const because of std::env::current_dir().
lazy_static! {
    /// The path to the LOGS directory.
    /// Used to store the logs from build and test commands.
    pub static ref LOGS_PATH: std::path::PathBuf = std::env::current_dir()
        .unwrap().join("LOGS");

    /// The path to the CI directory.
    /// Used to store the repositories that the server clones.
    pub static ref CI_PATH: std::path::PathBuf = std::env::current_dir()
        .unwrap().join("CI");
}

#[tokio::main]
/// Starts the CI server and handles all the routes.
async fn main() {
    let app = Router::new().route("/github_webhook", post(github_webhook));

    let listener = tokio::net::TcpListener::bind("0.0.0.0:8007").await.unwrap();
    println!("Listening on {}", listener.local_addr().unwrap());
    axum::serve(listener, app).await.unwrap();
}
