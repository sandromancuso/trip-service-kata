package org.craftedsw.harddependencies.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.harddependencies.exception.UserNotLoggedInException;
import org.craftedsw.harddependencies.user.User;

public class TripService {

	public List<Trip> getFriendTrips(User loggedUser, User friend) throws UserNotLoggedInException {
		validate(loggedUser);
		return (friend.isFriendsWith(loggedUser)) 
						? findTripsForFriend(friend)
					    : new ArrayList<Trip>();
	}

	private void validate(User loggedUser) throws UserNotLoggedInException {
		if (loggedUser == null) throw new UserNotLoggedInException();
	}

	protected List<Trip> findTripsForFriend(User friend) {
		return TripDAO.findTripsByUser(friend);
	}
}
