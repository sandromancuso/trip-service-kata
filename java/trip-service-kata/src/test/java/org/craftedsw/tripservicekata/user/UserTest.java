package org.craftedsw.tripservicekata.user;

import org.junit.Test;

import static org.craftedsw.tripservicekata.trip.UserBuilder.aUser;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserTest {
    private static final User BOB = new User();
    private static final User EVE = new User();

    @Test
    public void shouldTellWhenUsersAreNotFriend()
    {
        User alice = aUser().friendsWith(BOB)
                            .build();
        assertThat(alice.isFriendWith(EVE), is(false));
    }

    @Test
    public void shouldTellWhenUsersAreFriend()
    {
        User alice = aUser().friendsWith(BOB, EVE)
            .build();
        assertThat(alice.isFriendWith(EVE), is(true));
    }

}
