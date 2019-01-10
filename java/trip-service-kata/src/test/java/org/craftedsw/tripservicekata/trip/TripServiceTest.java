package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.craftedsw.tripservicekata.trip.UserBuilder.aUser;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TripServiceTest
{

    @Mock
    private TripDAO tripDAO;

    @InjectMocks
    @Spy
    private TripService tripService = new TripService();

    private static final User GUEST = null;
    private static final User UNUSED_USER = null;
    private static final User REGISTERED_USER = new User();
    private static final User ANOTHER_USER = new User();
    private static final Trip TO_BRITTANY = new Trip();
    private static final Trip TO_NORMANDY = new Trip();

    @Before
    public void initialize()
    {
        when(tripDAO.tripsBy(any(User.class)))
            .thenAnswer(invocation -> ((User) invocation.getArguments()[0]).trips());
    }

    @Test(expected = UserNotLoggedInException.class)
    public void shouldRaiseExceptionWhenUserNotLoggedIn()
    {
        tripService.getTripsByUser(UNUSED_USER, GUEST);
    }

    @Test
    public void shouldNotReturnAnyTripWhenUsersAreNotFriends()
    {
        User target = aUser().friendsWith(ANOTHER_USER)
                             .withTrips(TO_BRITTANY)
                             .build();
        assert tripService.getTripsByUser(target, REGISTERED_USER).isEmpty();
    }

    @Test
    public void shouldReturnFriendTripsWhenUsersAreFriends()
    {
        User target = aUser().friendsWith(ANOTHER_USER, REGISTERED_USER)
                             .withTrips(TO_BRITTANY, TO_NORMANDY)
                             .build();
        assertThat(tripService.getTripsByUser(target, REGISTERED_USER).size(), is(2));
    }

}
