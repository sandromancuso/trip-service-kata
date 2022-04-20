package org.craftedsw.tripservicekata.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {

  private static final User BOB = new User();
  private static final User PAUL = new User();

  @Test
  @DisplayName("告知該使用者不是朋友")
  void should_inform_when_users_are_not_friends() throws Exception {
    User user = new User();
    user.addFriend(BOB);
    
    assertThat(user.isFriendsWith(PAUL)).isEqualTo(false);
  }
}
