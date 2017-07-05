package org.craftedsw.tripservicekata.trip

import org.craftedsw.tripservicekata.user.{UserSession, User}
import org.craftedsw.tripservicekata.exception.UserNotLoggedInException

import scala.util.control.Breaks._

class TripService(userSession: UserSession, tripDAO: TripDAO) {

	def getTripsOfFriend(user: User, loggedInUser: User): List[Trip] =
		user.friends().find(_ == loggedInUser).map(tripDAO.findTripsByUser).getOrElse(Nil)

	def getTripsByUser(user: User): List[Trip] =
		Option(userSession.getLoggedUser()).map(getTripsOfFriend(user, _)).getOrElse(throw new UserNotLoggedInException)

}
