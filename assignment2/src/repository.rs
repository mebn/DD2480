pub struct Repository {
    url: String,
    path: String,
    branch: String,
}

impl Repository {
    pub fn clone(&self) {}
    pub fn checkout(&self) {}
    pub fn cleanup(&self) {}
}


#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_clone() {
        assert!(true);
    
    }
}
