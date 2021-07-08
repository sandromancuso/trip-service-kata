use trip::Trip;

pub struct User {
    name: String,
    friends: Vec<Box<User>>,
    trips: Vec<Trip>,
}

impl User {
    pub fn new(name: String) -> Self {
        User {
            name,
            friends: Vec::new(),
            trips: Vec::new(),
        }
    }

    pub fn friends(&self) -> &Vec<Box<User>> {
        &self.friends
    }

    pub fn add_friend(&mut self, friend: User) {
        self.friends.push(Box::new(friend))
    }

    pub fn add_trip(&mut self, trip: Trip) {
        self.trips.push(trip)
    }
}

impl PartialEq for User {
    fn eq(&self, other: &User) -> bool {
        self.name == other.name
    }
}
