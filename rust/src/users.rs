use crate::trip_service;
use trip_service::Trip;
use lazy_static::lazy_static;

pub struct User {
    pub id: i32,
    trips: Vec<Trip>,
    friends: Vec<User>,
}

impl User {
    pub fn get_friends(&self) -> &Vec<User> {
        &self.friends
    }

    pub fn add_friend(&mut self, user: User) {
        self.friends.push(user);
    }

    pub fn trips(&self) -> &Vec<Trip> {
        &self.trips
    }

    pub fn add_trip(& mut self, trip: Trip) {
        self.trips.push(trip);
    }
}

impl PartialEq for User {
    fn eq(&self, other: &Self) -> bool {
        self.id == other.id
    }
}

pub struct UserSession {
}

lazy_static! {
    pub static ref ONE_USER_SESSION: UserSession = {
        UserSession {}
    };
}

impl UserSession {
    pub fn is_user_logged_in(&self, _user: &User) -> Result<bool, &'static str> {
        Err("UserSession.is_user_logged_in() should not be called in an unit test")
    }

    pub fn get_logged_user(&self) -> Result<User, &'static str> {
        Err("UserSession.get_logged_user() should not be called in an unit test")
    }
}
