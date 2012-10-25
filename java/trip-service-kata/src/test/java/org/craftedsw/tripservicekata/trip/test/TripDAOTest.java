package org.craftedsw.tripservicekata.trip.test;

import org.craftedsw.tripservicekata.exception.DependendClassCallDuringUnitTestException;
import org.craftedsw.tripservicekata.trip.TripDAO;
import org.craftedsw.tripservicekata.user.User;
import org.junit.Test;

public class TripDAOTest {
	
	@Test(expected = DependendClassCallDuringUnitTestException.class) 
	public void should_throw_an_exception_when_return_trips_from_user() {
		 new TripDAO().tripsBy(new User());
	}

}
