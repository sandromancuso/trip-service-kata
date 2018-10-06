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

TEST(TripService, should_throw_in_no_user_logged_in) 
{
	TripServiceTestable tripService;

	User user{ 0 };

	EXPECT_THROW(tripService.GetTripsByUser(user), UserNotLoggedInException);
}


TEST(TripService, should_return_no_trip_if_users_are_not_friends)
{
	TripServiceTestable tripService;

	User user{ 0 };
	User loggedUser{1};
	tripService.loggedInUser = &loggedUser;
	EXPECT_EQ(0,tripService.GetTripsByUser(user).size());
}