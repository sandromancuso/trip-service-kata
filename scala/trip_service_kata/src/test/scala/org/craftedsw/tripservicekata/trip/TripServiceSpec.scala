package org.craftedsw.tripservicekata.trip

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException
import org.craftedsw.tripservicekata.user.{EmptySession, SingleRelationshipSession, SingleUserSession, User}
import org.scalatest.{FlatSpec, Matchers}

class TripServiceSpec extends FlatSpec with Matchers {

  behavior of "TripService"

  val serviceEmpty = new TripService(EmptySession, EmptyTripDAO)
  val serviceSingleUserNoTrips = new TripService(SingleUserSession, EmptyTripDAO)
  val serviceSingleRelationshipNoTrips = new TripService(SingleRelationshipSession, EmptyTripDAO)
  val serviceSingleRelationshipWithTrips = new TripService(SingleRelationshipSession, NonEmptyTripDAO)

  it should "throw a UserNotLoggedInException if there is no logged user" in {

    a[UserNotLoggedInException] should be thrownBy (serviceEmpty.getTripsByUser(new User))

  }

  it should "not throw an exception when querying for the only user in the singleton session" in {

    an[Exception] shouldNot be(thrownBy(serviceSingleUserNoTrips.getTripsByUser(SingleUserSession.onlyUser)))

  }

  it should "return an empty list if querying the singleton session for a user without friends" in {

    serviceSingleUserNoTrips.getTripsByUser(new User) shouldBe empty

  }

  it should "return an empty list if querying for a user friend with no trips" in {

    serviceSingleRelationshipNoTrips.getTripsByUser(SingleRelationshipSession.loggedInUserFriend) shouldBe empty

  }

  it should "return a non-empty list if querying for a user friend with some trips" in {

    serviceSingleRelationshipWithTrips.getTripsByUser(SingleRelationshipSession.loggedInUserFriend) shouldNot be(empty)

  }

}
