package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserBuilder {

    private final List<User> friends = new ArrayList<>();
    private final List<Trip> trips = new ArrayList<>();

    public static UserBuilder aUser() {
        return new UserBuilder();
    }

    public UserBuilder friendsWith(final User... friends) {
        this.friends.addAll(Stream.of(friends).collect(Collectors.toList()));
        return this;
    }

    public UserBuilder withTrips(final Trip... trips) {
        this.trips.addAll(Stream.of(trips).collect(Collectors.toList()));
        return this;
    }

    public User build() {
        final User user = new User();
        addTripsToUser(user);
        addFriendsToUser(user);
        return user;
    }

    private void addFriendsToUser(User user) {
        friends.forEach(user::addFriend);
    }

    private void addTripsToUser(User user) {
        trips.forEach(user::addTrip);
    }
}
