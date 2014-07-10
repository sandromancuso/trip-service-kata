package org.craftedsw.tripservicekata.trip

import org.craftedsw.tripservicekata.exception.DependendClassCallDuringUnitTestException
import org.craftedsw.tripservicekata.user.User
import spock.lang.Specification

class TripDAOSpec extends Specification {

    def "should throw an exception when return trips from user"() {
        when:
        new TripDAO().tripsBy(new User());

        then:
        thrown(DependendClassCallDuringUnitTestException)
    }

}