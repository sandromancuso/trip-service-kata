using System.Collections.Generic;
using TripServiceKata.Exception;
using TripServiceKata.User;

namespace TripServiceKata.Trip
{
    public class TripService
    {
        private readonly IUserSession _userSession;
        private readonly ITripRepository _tripRepository;

        public TripService(IUserSession userSession, ITripRepository tripRepository)
        {
            _userSession = userSession;
            _tripRepository = tripRepository;
        }

        public List<Trip> GetTripsByUser(User.User user)
        {
            User.User loggedUser = _userSession.GetLoggedUser();
            if (loggedUser == null)
            {
                throw new UserNotLoggedInException();
            }
            return user.IsFriend(loggedUser)
                ? _tripRepository.FindTripsByUser(user)
                : new List<Trip>();
        }
    }
}
