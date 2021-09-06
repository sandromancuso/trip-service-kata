package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.CollaboratorCallException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TripDAOTest {

    @Test
    void should_throw_exception_when_retrieving_user_trips() {
        assertThrows(CollaboratorCallException.class, () -> new TripDAO().tripsBy(new User()));
    }
}
