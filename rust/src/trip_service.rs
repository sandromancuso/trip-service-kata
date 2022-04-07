use crate::users;

#[derive(Debug, Clone)]
pub struct Trip {}

struct TripDAO {}

impl TripDAO {
    pub fn find_trips_by_user(user: &users::User) -> Result<Vec<Trip>, &'static str> {
        Err("TripDAO should not be invoked on an unit test.")
    }
}

pub struct TripService {}

impl TripService {
    pub fn get_trips_by_user(user: &users::User) -> Vec<Trip> {
        let mut trip_list: Vec<Trip> = vec![];

        let logged_user = &users::ONE_USER_SESSION.get_logged_user().unwrap();

        let mut is_friend: bool = false;

        for i in user.get_friends() {
            if i == logged_user {
                is_friend = true;
                break;
            }
        }

        if is_friend {
            trip_list = TripDAO::find_trips_by_user(user).unwrap();
        }
        trip_list
    }

    pub fn build_check(&self) {
        println!("Built and runnable!");
    }
}
