package org.craftedsw.tripservicekata.user;

import org.craftedsw.tripservicekata.trip.UserBuilder;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class UserTest {

    private static final User BOB = UserBuilder.aUser().build();
    private static final User PAUL = UserBuilder.aUser().build();

    @Test
    void should_return_false_when_users_are_not_friends() {
        final User user = UserBuilder.aUser()
                .friendsWith(BOB)
                .build();

        assertThat(user.isFriendsWith(PAUL), is(false));
    }

    @Test
    void should_return_true_when_users_are_friends() {
        final User user = UserBuilder.aUser()
                .friendsWith(BOB, PAUL)
                .build();

        assertThat(user.isFriendsWith(PAUL), is(true));
    }
}
