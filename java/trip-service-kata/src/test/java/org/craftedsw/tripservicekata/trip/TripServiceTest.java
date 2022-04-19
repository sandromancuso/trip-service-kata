package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TripServiceTest {
	
  
  @Test
  @DisplayName("使用者未登入丟出例外")
  void should_throw_exception_when_user_is_not_logged_in() throws Exception {
    TripService tripService = new TestableTripService();
    
    tripService.getTripsByUser(null);
  }
  
  private class TestableTripService extends TripService {

    @Override
    protected User getLoggedUser() {
      return null;
    }
    
  }
}
