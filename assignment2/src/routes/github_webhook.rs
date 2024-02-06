//! Routes for handling GitHub webhooks.

use axum::http::{HeaderMap, StatusCode};

/// Handles the GitHub webhook.
/// Does different things depending on the event type.
///
/// E.g. if the event is a pull request, it will run the CI pipeline.
pub async fn github_webhook(headers: HeaderMap, body: String) -> StatusCode {
    println!("{:?}", headers);
    println!("{:?}", body);

    let github_event = headers.get("x-github-event");

    if let None = github_event {
        return StatusCode::BAD_REQUEST;
    }

    let github_event = github_event.unwrap().to_str().unwrap();

    if github_event == "pull request" {
        println!("Pull request event");
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

        return StatusCode::OK;
    }

    StatusCode::OK
}

#[cfg(test)]
mod tests {
    use super::*;

    #[tokio::test]
    /// Should return a 200 OK status code
    /// when the GitHub event is a pull request.
    async fn test_github_webhook_ok() {
        let mut headers = HeaderMap::new();
        headers.insert("x-github-event", "pull_request".parse().unwrap());

        let status = github_webhook(headers, "".into()).await;
        assert_eq!(status, StatusCode::OK);
    }

    #[tokio::test]
    /// Should return a 400 Bad Request status code
    /// when the event type is not recognized/handled.
    async fn test_github_webhook_bad_request() {
        let mut headers = HeaderMap::new();
        headers.insert(
            "this-header-does-not-exist",
            "pull_request".parse().unwrap(),
        );

        let status = github_webhook(headers, "".into()).await;
        assert_eq!(status, StatusCode::BAD_REQUEST);
    }
}
