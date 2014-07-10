package org.craftedsw.tripservicekata.user

import org.craftedsw.tripservicekata.user.test.UserBuilder
import spock.lang.Specification

class UserSpec extends Specification {

    User BOB = new User();
    User PAUL = new User();

    def "should inform when users are not friends"() {
        given:
        def user = UserBuilder.aUser()
                .friendsWith(BOB).build();

        expect:
        false == user.isFriendsWith(PAUL)
    }

    def "should inform whenusers are friends"() {
        given:
        def user = UserBuilder.aUser()
                .friendsWith(BOB, PAUL).build();

        expect:
        user.isFriendsWith(PAUL)
    }

}