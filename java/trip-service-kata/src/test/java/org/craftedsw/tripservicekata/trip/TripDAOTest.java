package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TripDAOTest {

    @Test
    void WHEN_UserIsNotLogin_THEN_ThrowUserNotLoggedInException(){
        // Arrange
        NoLoginTripService noLoginTripService = new NoLoginTripService();
        // Act & Assert
        Assertions.assertThrows(
                UserNotLoggedInException.class,
                () -> noLoginTripService.getTripsByUser(null)
        );
    }

    private class NoLoginTripService extends TripService{
        @Override
        public User getLoggedUser() {
            return null;
        }
    }

}
