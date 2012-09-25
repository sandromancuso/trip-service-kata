package org.craftedsw.harddependencies.user;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.harddependencies.trip.Trip;

public class User {

	private List<Trip> trips = new ArrayList<Trip>();
	private List<User> friends = new ArrayList<User>();
	
	public List<User> getFriends() {
		return friends;
	}
	
	public void addFriend(User user) {
		friends.add(user);
	}

	public boolean isFriendsWith(User friend) {
		return friends.contains(friend);
	}
	
	public void addTrip(Trip trip) {
		trips.add(trip);
	}
	
	public List<Trip> trips() {
		return trips;
	}

}
