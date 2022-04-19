package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

public class TripService {

	public List<Trip> getTripsByUser(User loggedUser, User theOtherUser) throws UserNotLoggedInException {
		List<Trip> tripList = new ArrayList<Trip>();
		if (loggedUser != null) {
			if (theOtherUser.isFriendWith(loggedUser)) {
				tripList = findTripsByUser(theOtherUser);
			}
			return tripList;
		} else {
			throw new UserNotLoggedInException();
		}
	}

	public List<Trip> findTripsByUser(User user) {
		return TripDAO.findTripsByUser(user);
	}
	
}
