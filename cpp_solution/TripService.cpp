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


std::list<Trip> TripService::GetTripsByUser(User& user, User* loggedUser)
{
	User* loggedUserLocal = getLoggedInUser();

	if (!loggedUserLocal)
	{
		throw UserNotLoggedInException("UserNotLoggedInException");
	}

	if (user.isFriendWith(*loggedUserLocal))
	{
		return findTripsByUser(user);
	}

	return NO_TRIPS;
}
