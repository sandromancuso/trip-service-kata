package org.craftedsw.tripservicekata.trip;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.List;
import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TripServiceTest {
	
  
  private static final User GUEST = null;
  private static final User UNUSED_USER = null;
  private static final User REGISTERED_USER = new User();
  private static final User ANOTHER_USER = new User();
  private static final Trip TO_USA = new Trip();
  private static final Trip TO_TAIWAN = new Trip();
  
  @Mock
  private TripDAO tripDAO;
  
  @InjectMocks 
  @Spy
  private TripService realTripService = new TripService();
  
  private TripService tripService;

  @BeforeEach
  void beforeEach() {
    tripService = new TestableTripService();
    
  }
  
  @Test
  @DisplayName("使用者未登入丟出例外")
  void should_throw_exception_when_user_is_not_logged_in() throws Exception {
    
    //assert
    assertThatExceptionOfType(UserNotLoggedInException.class)
      .isThrownBy(() -> tripService.getTripsByUser(UNUSED_USER, GUEST));
    
  }
  
  @Test
  @DisplayName("如果不是朋友，就看不到其旅遊行程")
  void should_not_return_trips_when_users_not_friends() throws Exception {
    // arrange
    User friend = new User();
    friend.addFriend(ANOTHER_USER);
    friend.addTrip(TO_USA);
    
    List<Trip> trips = tripService.getTripsByUser(friend, REGISTERED_USER);
    
    assertThat(trips.size()).isEqualTo(0);
    
  }
  
  @Test
  @DisplayName("如果是朋友，就可看其旅遊行程")
  void return_trips_when_users_are_friends() throws Exception {
    // arrange
    User friend = new User();
    friend.addFriend(ANOTHER_USER);
    friend.addFriend(REGISTERED_USER);
    friend.addTrip(TO_USA);
    friend.addTrip(TO_TAIWAN);
    
    List<Trip> trips = tripService.getTripsByUser(friend, REGISTERED_USER);
    
    assertThat(trips.size()).isEqualTo(2);
  }
  
  private class TestableTripService extends TripService {

    @Override
    protected List<Trip> tripsBy(User user) {
      return user.trips();
    }
  }
}
