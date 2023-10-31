"use strict";

class User {
	friends = [];
	trips = [];

	getFriends = () => this.friends;
	getTrips = () => this.trips;

	addFriend = (newFriend) => this.friends.push(newFriend);
	addTrip = (newTrip) => this.trips.push(newTrip);
}

module.exports = User
