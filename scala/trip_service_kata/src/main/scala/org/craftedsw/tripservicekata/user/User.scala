package org.craftedsw.tripservicekata.user

import scala.collection.mutable
import org.craftedsw.tripservicekata.trip.Trip

class User {

	val tripList: mutable.MutableList[Trip] = mutable.MutableList()
	val friendList: mutable.MutableList[User] = mutable.MutableList()

	def friends(): List[User] = {
		friendList toList
	}

	def addFriend(user: User) = {
		friendList += user
	}

	def trips(): List[Trip] = {
		tripList toList
	}

	def addTrip(trip: Trip) = {
		tripList += trip
	}

}
