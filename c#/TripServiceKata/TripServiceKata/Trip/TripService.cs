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
            List<Trip> tripList = new List<Trip>();
            User.User loggedUser = _userSession.GetLoggedUser();
            bool isFriend = false;
            if (loggedUser == null)
            {
                throw new UserNotLoggedInException();
            }

            foreach (User.User friend in user.GetFriends())
            {
                if (friend.Equals(loggedUser))
                {
                    isFriend = true;
                    break;
                }
            }
            if (isFriend)
            {
                tripList = _tripRepository.FindTripsByUser(user);
            }
            return tripList;
        }
    }
}
