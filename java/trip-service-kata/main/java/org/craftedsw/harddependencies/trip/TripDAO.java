package org.craftedsw.harddependencies.trip;

import java.util.List;

import org.craftedsw.harddependencies.exception.DependendClassCallDuringUnitTestException;
import org.craftedsw.harddependencies.user.User;

public class TripDAO {

	public static List<Trip> findTripsByUser(User user) {
		throw new DependendClassCallDuringUnitTestException(
				"TripDAO should not be invoked on an unit test.");
	}
	
}