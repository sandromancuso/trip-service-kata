using NUnit.Framework;
using TripServiceKata.Trip;
using TripServiceKata.User;

namespace TripServiceKata.Tests
{
    [TestFixture]
    public class TripServiceTest
    {
        [Test]
        public void HappyPath()
        {
            var sut = new TripService();
            var user = new User.User();
            var res = sut.GetTripsByUser(user);
            Assert.That(res, Is.Not.Null);
        }
    }
}
