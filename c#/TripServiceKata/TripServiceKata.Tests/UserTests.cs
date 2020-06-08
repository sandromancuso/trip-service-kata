using TripServiceKata.User;
using Xunit;

namespace Trip
{
    public class UserTests
    {
        [Fact]
        public void IsFriendReturnsFalse()
        {
            Assert.False(new User().IsFriend(new User()));
        }

        [Fact]
        public void IsFriendReturnsTrue()
        {
            var friend = new User();
            User user = new User();
            user.AddFriend(friend);
            Assert.True(user.IsFriend(friend));
        }
    }
}