package org.craftedsw.tripservicekata.trip;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TripServiceTest {
	
  
  @Test
  @DisplayName("使用者未登入丟出例外")
  void should_throw_exception_when_user_is_not_logged_in() throws Exception {
    // arrange
    TripService tripService = new TestableTripService();
    
    // act
    //assert
    assertThatExceptionOfType(UserNotLoggedInException.class)
      .isThrownBy(() -> tripService.getTripsByUser(null));
    
  }
  
  private class TestableTripService extends TripService {

    @Override
    protected User getLoggedUser() {
      return null;
    }
    
  }
}
