package org.craftedsw.tripservicekata.trip

import org.craftedsw.tripservicekata.user.User
import org.craftedsw.tripservicekata.exception.CollaboratorCallException

object TripDAO {

	def findTripsByUser(user: User): List[Trip] = {
		throw new CollaboratorCallException(
			"TripDAO should not be invoked on an unit test.");
	}

}
