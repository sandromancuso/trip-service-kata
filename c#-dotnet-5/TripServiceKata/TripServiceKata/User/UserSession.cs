using TripServiceKata.Exception;

namespace TripServiceKata.User
{
    public class UserSession
    {
        private static readonly UserSession userSession = new UserSession();

        private UserSession() { }

        public static UserSession GetInstance()
        {
            return userSession;
        }

        public bool IsUserLoggedIn(User user)
        {
            throw new DependentClassCallDuringUnitTestException(
                "UserSession.IsUserLoggedIn() should not be called in an unit test");
        }

        public User GetLoggedUser()
        {
            throw new DependentClassCallDuringUnitTestException(
                "UserSession.GetLoggedUser() should not be called in an unit test");
        }
    }
}