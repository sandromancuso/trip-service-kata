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
		for (i = user.GetFriends().begin(); i != user.GetFriends().end(); ++i)
		{
			if (*i == *loggedUser)
			{
				isFriend = true;
				break;
			}
		}
		if (isFriend)
		{
			return findTripsByUser(user);
		}
		return std::list<Trip>{};
	}
	else
	{
		throw UserNotLoggedInException("UserNotLoggedInException");
	}
}
