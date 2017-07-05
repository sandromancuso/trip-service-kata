package org.craftedsw.tripservicekata.trip
import org.craftedsw.tripservicekata.user.User

object EmptyTripDAO extends TripDAO {

  override def findTripsByUser(user: User): List[Trip] = Nil

}
