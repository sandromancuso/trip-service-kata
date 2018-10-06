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
	
	User user{ 0 };
};

TEST_F(TripServiceTest, should_throw_in_no_user_logged_in) 
{


	EXPECT_THROW(tripService.GetTripsByUser(user), UserNotLoggedInException);
}


TEST_F(TripServiceTest, should_return_no_trip_if_users_are_not_friends)
{
	User loggedUser{1};
	tripService.loggedInUser = &loggedUser;
	EXPECT_EQ(0,tripService.GetTripsByUser(user).size());
}