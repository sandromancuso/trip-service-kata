package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Test;

public class TripDAOTest {

  @Test
  void should_throw_exception_when_get_user_trips() throws Exception {
    new TripDAO().tripsBy(new User());
//    assertThatExceptionOfType(null)
  }
}
