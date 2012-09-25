using System.Collections.Generic;
using TripServiceKata.Exception;

namespace TripServiceKata.Trip
{
    public class TripService
    {
        public List<Trip> GetTripsByUser(User.User user)
        {
            List<Trip> tripList = new List<Trip>();
            User.User loggedUser = UserSession.GetInstance().getLoggedUser();
            bool isFriend = false;
            if (loggedUser != null)
            {
                foreach(User.User friend in user.GetFriends())
                {
                    if (friend.Equals(loggedUser))
                    {
                        isFriend = true;
                        break;
                    }
                }
                if (isFriend)
                {
                    tripList = TripDAO.FindTripsByUser(user);
                }
                return tripList;
            }
            else
            {
                throw new UserNotLoggedInException();
            }
        }
    }
}
