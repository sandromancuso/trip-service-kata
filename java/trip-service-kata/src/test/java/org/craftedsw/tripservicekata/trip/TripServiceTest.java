package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TripServiceTest {

    private static final User GUEST = null;

    private static final User UNUSED_USER = null;
    private static final User REGISTERED_USER = new User();
    private static final User ANOTHER_USER = new User();
    private static final Trip TO_BRAZIL = new Trip();
    private static final Trip TO_LONDON = new Trip();
    private User loggedInUser;
    private TripService tripService;

    @BeforeEach
    public void initialize() {
        tripService = new TestableTripService();
        loggedInUser = REGISTERED_USER;
    }

    @Test
    public void should_throw_exception_when_user_not_logged_in() {
        loggedInUser = GUEST;

        assertThrows(UserNotLoggedInException.class, () -> tripService.getTripsByUser(UNUSED_USER));
    }

    @Test
    public void should_return_trip_list_when_user_is_a_friend() {
        final User friend = new User();
        friend.addFriend(loggedInUser);
        friend.addTrip(TO_BRAZIL);
        friend.addTrip(TO_LONDON);

        final List<Trip> trips = tripService.getTripsByUser(friend);

        assertThat(trips, hasSize(2));
        assertThat(trips, contains(TO_BRAZIL, TO_LONDON));
    }


    @Test
    public void should_return_empty_list_when_user_in_not_friend() {
        final User friend = new User();

        friend.addFriend(ANOTHER_USER);
        friend.addTrip(TO_BRAZIL);

        final List<Trip> trips = tripService.getTripsByUser(friend);

        assertThat(trips, is(empty()));
    }


    private class TestableTripService extends TripService {

        @Override
        protected User getLoggedUser() {
            return loggedInUser;
        }

        @Override
        protected List<Trip> getTripsList(User user) {
            return user.trips();
        }

    }

}
