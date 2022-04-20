package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

public class TripService {

  public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
    if (getLoggedUser() == null) {
      throw new UserNotLoggedInException();
    }

    return user.isFriendsWith(getLoggedUser()) 
        ? tripsBy(user) 
        : noTrips();
  }

  private ArrayList<Trip> noTrips() {
    return new ArrayList<Trip>();
  }

  protected List<Trip> tripsBy(User user) {
    return TripDAO.findTripsByUser(user);
  }

  protected User getLoggedUser() {
    return UserSession.getInstance().getLoggedUser();
  }

}
