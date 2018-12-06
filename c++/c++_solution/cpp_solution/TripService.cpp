#include "pch.h"
#include "TripService.h"

#include <list>


std::list<Trip> TripService::GetTripsByUser(User& user)
{
	std::list<Trip> tripList;
	User* loggedUser = UserSession::GetInstance()->GetLoggedUser();
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
			tripList = TripDAO::FindTripsByUser(user);
		}
		return tripList;
	}
	else
	{
		throw UserNotLoggedInException("UserNotLoggedInException");
	}
}











//UserSession* UserSession::oneUserSession;
