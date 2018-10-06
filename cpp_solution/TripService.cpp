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
	std::list<Trip> tripList;
	User* loggedUser = getLoggedInUser();
	bool isFriend = false;
	if (loggedUser)
	{
		std::list<User>::iterator i;
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
			tripList = findTripsByUser(user);
		}
		return tripList;
	}
	else
	{
		throw UserNotLoggedInException("UserNotLoggedInException");
	}
}











//UserSession* UserSession::oneUserSession;
