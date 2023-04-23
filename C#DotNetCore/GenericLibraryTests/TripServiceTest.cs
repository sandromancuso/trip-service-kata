using Xunit;
using TripServiceKata.Trip;
using TripServiceKata.User;

namespace TripServiceKata.Tests
{
    
    public class TripServiceTest
    {
        //kata:  make this test green!
        // but do not modify implementation of UserSession, nor TripDAO
        [Fact]  
        public void HappyPath()
        {
            var sut = new TripService();
            var user = new User.User();
            var res = sut.GetTripsByUser(user);
            
            Assert.NotEmpty(res);
        }
    }
}
