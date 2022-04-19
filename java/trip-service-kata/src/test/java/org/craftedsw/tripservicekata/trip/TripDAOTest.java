package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TripDAOTest {
    private User loggedUser;
    private User theOtherUser;

    @BeforeEach
    void init(){
        loggedUser = new User();
        theOtherUser = new User();
    }

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
        List<Trip> actual = noLoginTripService.getTripsByUser(theOtherUser);
        // Assert
        ArrayList<Trip> expect = new ArrayList<>();
        Assertions.assertArrayEquals(expect.toArray(), actual.toArray());
    }

    private class NotFriendTripService extends TripService{
        @Override
        public User getLoggedUser() {
            return loggedUser;
        }
    }

    @Test
    void WHEN_UserIsFriend_THEN_ReturnTripList() {
        // Arrange
        IsFriendTripService isFriendTripService = new IsFriendTripService();
        theOtherUser.addFriend(loggedUser);
        // Act
        List<Trip> actual = isFriendTripService.getTripsByUser(theOtherUser);
        // Assert
        ArrayList<Trip> expect = new ArrayList<>();
        expect.add(new Trip());
        Assertions.assertArrayEquals(expect.toArray(), actual.toArray());

    }

    private class IsFriendTripService extends TripService{
        @Override
        public User getLoggedUser() {
            return loggedUser;
        }

        @Override
        public List<Trip> findTripsByUser(User user) {
            ArrayList<Trip> trips = new ArrayList<>();
            trips.add(new Trip());
            return trips;
        }
    }

}
