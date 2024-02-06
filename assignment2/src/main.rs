#![warn(missing_docs)]

mod ci;
mod github;
mod repository;

const REPO_PATH: &str = "/tmp/repo";
const LOG_PATH: &str = "/tmp/repo";

fn main() {
    println!("Hello, world!");
    // server
}

fn handle_webhook() {
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
}
