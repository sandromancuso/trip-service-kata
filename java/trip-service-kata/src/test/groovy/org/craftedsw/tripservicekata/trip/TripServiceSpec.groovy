package org.craftedsw.tripservicekata.trip

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException
import org.craftedsw.tripservicekata.user.User
import org.craftedsw.tripservicekata.user.test.UserBuilder
import spock.lang.Specification

class TripServiceSpec extends Specification {

    User UNUSED_USER = null;
    User ANOTHER_USER = new User();
    Trip TO_BRAZIL = new Trip();
    User GUEST = null;
    User LOGGED_IN_USER = new User();
    Trip TO_LONDON = new Trip();

    TripDAO tripDao = Mock()
    TripService tripService = new TripService()

    def setup() {
        tripService.tripDAO = tripDao
    }

    def "should thrown an exception when user is not logged in"() {
        when:
        tripService.getTripsByUser(UNUSED_USER, GUEST)

        then:
        thrown(UserNotLoggedInException)
    }

    def "should not return any trips when users are not friends"() {
        given:
        def friend = UserBuilder.aUser()
                .friendsWith(ANOTHER_USER)
                .withTrips(TO_BRAZIL)
                .build();

        when:
        def friendTrips = tripService.getTripsByUser(friend, LOGGED_IN_USER)

        then:
        friendTrips.size() == 0
    }

    def "should return trips when users are friends"() {
        given:
        def friend = UserBuilder.aUser()
                .friendsWith(ANOTHER_USER, LOGGED_IN_USER)
                .withTrips(TO_BRAZIL, TO_LONDON)
                .build()
        and:
        tripDao.tripsBy(friend) >> friend.trips()

        when:
        def friendTrips = tripService.getTripsByUser(friend, LOGGED_IN_USER)

        then:
        friendTrips.size() == 2
    }
}
