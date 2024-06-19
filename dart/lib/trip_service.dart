import 'package:trip_service/trip_service_error_type.dart';
import 'package:trip_service/trip.dart';
import 'package:trip_service/user.dart';
import 'package:trip_service/trip_dao.dart';
import 'package:trip_service/user_session.dart';

class TripService {
  Future<List<Trip>?> getTripsByUser(User user) async {
    List<Trip>? tripList;
    User? loggedUser = await UserSession.instance.getLoggedUser();

    bool isFriend = false;

    if (loggedUser != null) {
      for (User friend in user.getFriends()) {
        if (friend == loggedUser) {
          isFriend = true;
          break;
        }
      }
      if (isFriend) {
        tripList = await TripDAO.findTripsByUser(user);
      }
      return tripList;
    } else {
      throw TripServiceErrorType.userNotLoggedIn;
    }
  }
}
