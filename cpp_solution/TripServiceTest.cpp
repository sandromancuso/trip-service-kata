#include "pch.h"
#include "TripService.h"

struct TripServiceTestable : TripService
{
protected:
	User* getLoggedInUser() override
	{
		return nullptr;	
	}
};

TEST(TripService, should_throw_in_no_user_logged_in) 
{
	TripServiceTestable tripService;

	User user{ 0 };

	EXPECT_THROW(tripService.GetTripsByUser(user), UserNotLoggedInException);
}