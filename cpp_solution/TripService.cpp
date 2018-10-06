#include "pch.h"
#include "TripService.h"

#include <list>


User* TripService::getLoggedInUser()
{
	return UserSession::GetInstance()->GetLoggedUser();
}

std::list<Trip> TripService::findTripsByUser(User& user)
{
	return TripDAO::FindTripsByUser(user);
}

std::list<Trip> TripService::GetTripsByUser(User& user)
{
	User* loggedUser = getLoggedInUser();
	if (loggedUser)
	{
		std::list<User>::iterator i;
		bool isFriend = false;
		isFriend = (std::find(user.GetFriends().begin(), user.GetFriends().end(), *loggedUser) != user.GetFriends().end());
		if (isFriend)
		{
			return findTripsByUser(user);
		}
		return NO_TRIPS;
	}
	else
	{
		throw UserNotLoggedInException("UserNotLoggedInException");
	}
}
