package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;
import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;

public class TripService {

  public List<Trip> getTripsByUser(User user, User loggedUser) throws UserNotLoggedInException {
    if (loggedUser == null) {
      throw new UserNotLoggedInException();
    }

    return user.isFriendsWith(loggedUser) 
        ? tripsBy(user) 
        : noTrips();
  }

  private ArrayList<Trip> noTrips() {
    return new ArrayList<Trip>();
  }

  protected List<Trip> tripsBy(User user) {
    return TripDAO.findTripsByUser(user);
  }

}
