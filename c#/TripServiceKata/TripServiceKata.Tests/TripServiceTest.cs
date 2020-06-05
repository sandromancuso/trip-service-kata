using System.Collections.Generic;
using Moq;
using TripServiceKata.Exception;
using TripServiceKata.Trip;
using TripServiceKata.User;
using Xunit;

namespace TripServiceKata.Tests
{
    public class TripServiceTest
    {
        [Fact]
        public void UserNotLoggedIn()
        {
            var friend = new User.User();
            var tripRepoMock = new Mock<ITripRepository>();
            var userSessionMock = new Mock<IUserSession>();
            userSessionMock.Setup(session => session.GetLoggedUser()).Returns(() => null);
            var sut = new TripService(userSessionMock.Object, tripRepoMock.Object);
            Assert.Throws<UserNotLoggedInException>(() => sut.GetTripsByUser(friend));
        }

        [Fact]
        public void ReturnsEmptyWhenUserIsNotFriend()
        {
            var friend = new User.User();
            var tripRepoMock = new Mock<ITripRepository>();
            var userSessionMock = new Mock<IUserSession>();
            userSessionMock
                .Setup(session => session.GetLoggedUser())
                .Returns(new User.User());
            var sut = new TripService(userSessionMock.Object, tripRepoMock.Object);
            var trips = sut.GetTripsByUser(friend);
            Assert.Empty(trips);
        }

        [Fact]
        public void ReturnsTripsOfFriend()
        {
            var friend = new User.User();
            var currentUser = new User.User();
            friend.AddFriend(currentUser);
            var userSessionMock = new Mock<IUserSession>();
            userSessionMock
                .Setup(session => session.GetLoggedUser())
                .Returns(currentUser);
            var trips = new List<Trip.Trip>()
            {
                new Trip.Trip()
            };
            var tripRepoMock = new Mock<ITripRepository>();
            tripRepoMock
                .Setup(repo => repo.FindTripsByUser(friend))
                .Returns(trips);

            var sut = new TripService(userSessionMock.Object, tripRepoMock.Object);
            var actual = sut.GetTripsByUser(friend);
            Assert.Same(trips, actual);
        }
    }
}
