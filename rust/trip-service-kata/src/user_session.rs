use user::User;

pub static INSTANCE: UserSession = UserSession {};

pub struct UserSession {}

impl UserSession {
    pub fn logged_user(&self) -> Option<&User> {
        panic!("UserSession::logged_user() should not be called in an unit test")
    }
}
