<?php
class User {

	private $trips;
        
	private $friends;
	
        
        public function __construct() {
            $this->trips = array();
            $this->friends = array();
        }
        public function getTrips() {
            return $this->trips;
        }

        public function getFriends() {
            return $this->friends;
        }

        public function addFriend(User $user) {
            $this->friends[] = $user;
        }
        
        public function addTrip(Trip $trip) {
            $this->trips[] = $trip;
        }

        
}
?>