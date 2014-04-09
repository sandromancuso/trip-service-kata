package org.craftedsw.tripservicekata.trip

import org.craftedsw.tripservicekata.user.{UserSession, User}
import org.craftedsw.tripservicekata.exception.UserNotLoggedInException

import scala.util.control.Breaks._

class TripService {

	def getTripsByUser(user: User): List[Trip] = {
		var tripList: List[Trip] = List()
		val loggedInUser = UserSession getLoggedUser()
		var isFriend = false
		if (loggedInUser != null) {
			breakable { for (friend <- user.friends()) {
				if (friend == loggedInUser) {
					isFriend = true
					break
				}
			}}
			if (isFriend) {
				tripList = TripDAO.findTripsByUser(user)
			}
			tripList
		} else {
			throw new UserNotLoggedInException
		}
	}

}
