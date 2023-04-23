use user_session;
use user::User;
use trip_dao;
use trip::Trip;

pub fn get_trips_by_user(user: &User) -> Vec<&Trip> {
    let mut trip_list = Vec::new();
    let logged_user = user_session::INSTANCE.logged_user();
    let mut is_friend = false;
    if logged_user.is_some() {
        for friend in user.friends() {
            if **friend == *logged_user.unwrap() {
                is_friend = true;
                break;
            }
        }
        if is_friend {
            trip_list = trip_dao::find_trip_by_user(user);
        }
        trip_list
    } else {
        panic!("User not logged");
    }
}
