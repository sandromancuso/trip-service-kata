package org.craftedsw.tripservicekata.trip;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TripServiceTest {
	
  
  private static final User GUEST = null;
  private static final User UNUSED_USER = null;
  private static final User REGISTERED_USER = new User();
  private static final User ANOTHER_USER = new User();
  private static final Trip TO_USA = new Trip();
  private User loggedUser;

  @Test
  @DisplayName("使用者未登入丟出例外")
  void should_throw_exception_when_user_is_not_logged_in() throws Exception {
    // arrange
    TripService tripService = new TestableTripService();
    
    loggedUser = GUEST;
    
    // act
    //assert
    assertThatExceptionOfType(UserNotLoggedInException.class)
      .isThrownBy(() -> tripService.getTripsByUser(UNUSED_USER));
    
  }
  
  @Test
  @DisplayName("如果不是朋友，就看不到其旅遊行程")
  void should_not_return_trips_when_users_not_friends() throws Exception {
    // arrange
    TripService tripService = new TestableTripService();
    
    loggedUser = REGISTERED_USER;
    User friend = new User();
    friend.addFriend(ANOTHER_USER);
    friend.addTrip(TO_USA);
    
    List<Trip> trips = tripService.getTripsByUser(friend);
    
    assertThat(trips.size()).isEqualTo(0);
    
  }
  
  private class TestableTripService extends TripService {

    @Override
    protected User getLoggedUser() {
      return loggedUser;
    }
    
  }
}
