package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TripDAOTest {

    @Test
    void WHEN_UserIsNotLogin_THEN_ThrowUserNotLoggedInException(){
        // Arrange
        TripService noLoginTripService = new NoLoginTripService();
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

    @Test
    void WHEN_UserIsNotFriend_THEN_ReturnEmptyList(){
        // Arrange
        TripService noLoginTripService = new NotFriendTripService();
        // Act
        List<Trip> actual = noLoginTripService.getTripsByUser(new User());
        // Assert
        ArrayList<Trip> expect = new ArrayList<>();
        Assertions.assertArrayEquals(expect.toArray(), actual.toArray());
    }

    private class NotFriendTripService extends TripService{
        @Override
        public User getLoggedUser() {
            return new User();
        }
    }

}
