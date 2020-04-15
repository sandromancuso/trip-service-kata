package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TripServiceTest {

    private static final Trip POA = new Trip();
    private static final Trip LONDON = new Trip();
    private static User LOGGED_USER = new User();

    @Test
    void should_returns_UserNotLoggedInException_when_user_is_not_logged() {
        TripServiceTestableWithNotLoggedUser tripService = new TripServiceTestableWithNotLoggedUser();
        User juu = new User();

        Assertions.assertThrows(UserNotLoggedInException.class, () -> {
            tripService.getTripsByUser(juu);
        });
    }

    @Test
    void should_returns_emptyTrips_when_loggedUser_and_user_are_not_friends() {
        TripServiceTestableWithLoggedUser tripService = new TripServiceTestableWithLoggedUser();
        User andri = new User();

        List<Trip> trips = tripService.getTripsByUser(andri);

        assertTrue(trips.isEmpty());
    }

    @Test
    void should_returns_trips_when_loggedUser_and_user_are_friends() {
        TripServiceTestableWithLoggedUser tripService = new TripServiceTestableWithLoggedUser();
        User pipe = new User();
        pipe.addFriend(new User());
        pipe.addFriend(LOGGED_USER);

        List<Trip> trips = tripService.getTripsByUser(pipe);

        assertEquals(trips.get(0), POA);
        assertEquals(trips.get(1), LONDON);
    }



    public class TripServiceTestableWithNotLoggedUser extends TripService{

        @Override
        protected User getLoggedUser() {
            return null;
        }
    }

    public class TripServiceTestableWithLoggedUser extends TripService{

        @Override
        protected User getLoggedUser() {
            return LOGGED_USER;
        }

        @Override
        protected List<Trip> getTrips(User user) {
            return Arrays.asList(POA, LONDON);
        }
    }

}
