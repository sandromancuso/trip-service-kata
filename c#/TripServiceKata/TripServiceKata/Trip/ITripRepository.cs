using System.Collections.Generic;

namespace TripServiceKata.Trip
{
    public interface ITripRepository
    {
        List<Trip> FindTripsByUser(User.User user);
    }
}
