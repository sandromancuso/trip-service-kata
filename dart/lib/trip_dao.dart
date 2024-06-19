import 'package:trip_service/unit_tests_error_type.dart';
import 'package:trip_service/trip.dart';
import 'package:trip_service/user.dart';

class TripDAO {
  static Future<List<Trip>?> findTripsByUser(User user) async {
    throw UnitTestErrorType.dependendClassCallDuringUnitTest;
  }
}
