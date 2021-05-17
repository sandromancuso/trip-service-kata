package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TripServiceTest {


    @Test
    public void should_throw_exception_when_user_not_logged_in() {
        final TripService tripService = new TestableTripService();
        final User user = new User();
        assertThrows(UserNotLoggedInException.class, () -> tripService.getTripsByUser(user));
    }

    private static class TestableTripService extends TripService {
        @Override
        protected User getLoggedUser() {
            return null;
        }
    }
}
