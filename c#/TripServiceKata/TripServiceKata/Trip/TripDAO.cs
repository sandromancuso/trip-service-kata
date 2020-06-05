using System.Collections.Generic;
using TripServiceKata.Exception;

namespace TripServiceKata.Trip
{
    public class TripDAO : ITripRepository
    {
        public List<Trip> FindTripsByUser(User.User user)
        {
            throw new DependendClassCallDuringUnitTestException(
                "TripDAO should not be invoked on an unit test.");
        }
    }
}
