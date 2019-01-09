package org.craftedsw.tripservicekata.trip;

import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.Before;
import org.junit.Test;

import static org.craftedsw.tripservicekata.trip.UserBuilder.aUser;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TripServiceTest {

	private static final User GUEST = null;
	private static final User UNUSED_USER = null;
	private static final User REGISTERED_USER = new User();
	private static final User ANOTHER_USER = new User();
	private static final Trip TO_BRITTANY = new Trip();
    private static final Trip TO_NORMANDY = new Trip();
    private TripService tripService;

    @Before
    public void initialize()
    {
        tripService = new TestableTripService();
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


	public class TestableTripService extends TripService
	{

        @Override
        protected List<Trip> tripsBy(User user)
        {
            return user.trips();
        }
    }

}
