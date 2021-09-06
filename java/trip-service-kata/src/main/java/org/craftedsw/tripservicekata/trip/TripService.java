package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;

import java.util.ArrayList;
import java.util.List;

public class TripService {

    private final TripDAO tripDAO;

    public TripService(final TripDAO tripDAO) {
        this.tripDAO = tripDAO;
    }

    public List<Trip> getFriendTrips(User friend, User loggedInUser) throws UserNotLoggedInException {
        if (loggedInUser == null) {
            throw new UserNotLoggedInException();
        }
        return friend.isFriendsWith(loggedInUser)
                ? getTripsList(friend)
                : noTrips();
    }

    private ArrayList<Trip> noTrips() {
        return new ArrayList<>();
    }

    private List<Trip> getTripsList(final User user) {
        return tripDAO.tripsBy(user);
    }
}
