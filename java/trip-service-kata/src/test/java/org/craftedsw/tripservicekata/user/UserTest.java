package org.craftedsw.tripservicekata.user;

import org.junit.Test;

import static org.craftedsw.tripservicekata.trip.UserBuilder.aUser;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserTest
{
    private static final User ALICE = new User();
    private static final User BOB = new User();
    private static final User EVE = new User();

    @Test
    public void shouldTellWhenUsersAreNotFriend()
    {
        User alice = aUser().friendsWith(BOB).build();
        assertFalse(alice.isFriendWith(EVE));
    }

    @Test
    public void shouldTellWhenUsersAreFriend()
    {
        User alice = aUser().friendsWith(BOB).build();
        assertTrue(alice.isFriendWith(BOB));
    }

    @Test
    public void shouldReturnListOfFriends()
    {
        User victor = aUser().friendsWith(ALICE, BOB, EVE).build();
        assertEquals(victor.getFriends().size(), 3);

    }
}
