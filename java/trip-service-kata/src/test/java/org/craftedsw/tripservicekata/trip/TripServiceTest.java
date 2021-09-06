package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TripServiceTest {

    private static final User GUEST = null;
    private static final User UNUSED_USER = null;
    private static final User REGISTERED_USER = new User();
    private static final User ANOTHER_USER = new User();
    private static final Trip TO_BRAZIL = new Trip();
    private static final Trip TO_LONDON = new Trip();

    @Mock
    private TripDAO tripDAO;
    @InjectMocks
    private TripService tripService;

    @Test
    public void should_throw_exception_when_user_not_logged_in() {
        assertThrows(UserNotLoggedInException.class, () -> tripService.getFriendTrips(UNUSED_USER, GUEST));
    }

    @Test
    public void should_return_trip_list_when_users_are_friends() {
        User friend = UserBuilder.aUser()
                .friendsWith(ANOTHER_USER, REGISTERED_USER)
                .withTrips(TO_BRAZIL, TO_LONDON)
                .build();

        when(tripDAO.tripsBy(friend)).thenReturn(friend.trips());

        final List<Trip> trips = tripService.getFriendTrips(friend, REGISTERED_USER);

        assertThat(trips, hasSize(2));
        assertThat(trips, contains(TO_BRAZIL, TO_LONDON));
    }

    @Test
    public void should_return_empty_list_when_users_are_not_friends() {
        final User friend = UserBuilder.aUser()
                .friendsWith(ANOTHER_USER)
                .withTrips(TO_BRAZIL)
                .build();

        final List<Trip> trips = tripService.getFriendTrips(friend, REGISTERED_USER);

        assertThat(trips, is(empty()));
    }

}
