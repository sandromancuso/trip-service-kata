#include "pch.h"
#include "TripService.h"


struct TripDAOMock: TripDAO
{
	MOCK_METHOD1(FindTripsBy, std::list<Trip> (User&));
};

struct TripServiceTest: ::testing::Test
{
protected:
	void SetUp() override
	{
		anyUser.AddFriend(otherUser);
		anyUser.AddTrip(Trip{});
		anyUser.AddTrip(Trip{});
	}
public:

	explicit TripServiceTest() :tripDAO(new TripDAOMock{}), tripService{std::unique_ptr<TripDAOMock>(tripDAO)}
	{
	}

	TripDAOMock* tripDAO;
	TripService tripService;
	
	User anyUser{ 0 };
	User otherUser{2};
	User loggedUser{ 1 };
	User* GUEST_USER = nullptr;
};


TEST_F(TripServiceTest, should_throw_in_no_user_logged_in) 
{
	EXPECT_THROW(tripService.GetTripsByUser(anyUser, GUEST_USER), UserNotLoggedInException);
}

TEST_F(TripServiceTest, should_return_trips_if_user_are_friend_with_logged_in_user)
{
	anyUser.AddFriend(loggedUser);

	EXPECT_CALL(*tripDAO, FindTripsBy(anyUser)).WillOnce(testing::Return(anyUser.Trips()));
	
	EXPECT_EQ(2, tripService.GetTripsByUser(anyUser, &loggedUser).size());
}

TEST_F(TripServiceTest, should_return_no_trips_if_users_are_not_friends)
{
	EXPECT_EQ(0,tripService.GetTripsByUser(anyUser, &loggedUser).size());
}
