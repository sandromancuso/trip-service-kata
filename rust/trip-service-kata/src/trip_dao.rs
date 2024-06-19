use trip::Trip;
use user::User;

#[allow(unused_variables)]
pub fn find_trip_by_user(user:&User) -> Vec<&Trip>{
    panic!("find_trip_by_user() should not be called from tests")
}
