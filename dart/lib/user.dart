import 'package:trip_service/trip.dart';

class User {
  final List<Trip> _userTrips = [];
  final List<User> _friends = [];

  List<User> getFriends() {
    return _friends;
  }

  void addFriend(User friend) {
    _friends.add(friend);
  }

  List<Trip> getTrips() {
    return _userTrips;
  }

  void addTrip(Trip trip) {
    _userTrips.add(trip);
  }

  @override
  bool operator ==(Object other) => identical(this, other) || other is User && runtimeType == other.runtimeType;

  @override
  int get hashCode => _userTrips.hashCode ^ _friends.hashCode;
}
