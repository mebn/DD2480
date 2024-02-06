use crate::ci::Status;

struct WebhookData {
    repo: String,
}

pub struct Github {
    webhook_data: Option<WebhookData>,
}

impl Github {
    pub fn parse_webhook(&mut self, data: String) {}
    pub fn send_commit_status(&self, status: &Status) {}
}
