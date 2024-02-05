struct WebhookData {
}

pub struct Github {
    webhook_data: WebhookData,
}

impl Github {
    pub fn parse_webhook(&self) {}
    pub fn send_commit_status(&self) {}
}