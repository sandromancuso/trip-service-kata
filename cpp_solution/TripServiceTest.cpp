#include "pch.h"
#include "TripService.h"

struct TripServiceTestable : TripService
{
protected:
	User* getLoggedInUser() override
	{
		return loggedInUser;	
	}

public:
	User* loggedInUser = nullptr;
};

struct TripServiceTest: ::testing::Test
{
	TripServiceTestable tripService;
	
	User anyUser{ 0 };
	User otherUser{2};
	User* GUEST_USER = nullptr;
};

TEST_F(TripServiceTest, should_throw_in_no_user_logged_in) 
{
	tripService.loggedInUser = GUEST_USER;

	EXPECT_THROW(tripService.GetTripsByUser(anyUser), UserNotLoggedInException);
}


TEST_F(TripServiceTest, should_return_no_trip_if_users_are_not_friends)
{
	User loggedUser{1};
	tripService.loggedInUser = &loggedUser;
	anyUser.AddFriend(otherUser);
	anyUser.AddTrip(Trip{});
	anyUser.AddTrip(Trip{});

	EXPECT_EQ(0,tripService.GetTripsByUser(anyUser).size());
}