package org.craftedsw.tripservicekata.trip
import org.craftedsw.tripservicekata.user.User

object NonEmptyTripDAO extends TripDAO {
  override def findTripsByUser(user: User): List[Trip] = List(new Trip)
}
