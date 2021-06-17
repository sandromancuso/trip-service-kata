#ifndef TRIPSERVICE_CPP
#define TRIPSERVICE_CPP

#include "TripService.h"
#include "TripDAO.h"
#include "UserSession.h"
#include <iostream>
#include <list>

using namespace std;

UserSession* UserSession::oneUserSession = 0;

list<Trip> TripService::GetTripsByUser(User* user)
{
    list<Trip> triplist;
    User* loggedUser = UserSession::GetInstance()->GetLoggedUser();
    bool isFriend = false;
    if (loggedUser)
    {
        list<User>::iterator i;
        for (i = user->GetFriends().begin(); i != user->GetFriends().end(); ++i)
        {
            if (*i == *loggedUser)
            {
                isFriend = true;
                break;
            }
        }
        if (isFriend)
        {
            triplist = TripDAO::FindTripsByUser(user);
        }
        return triplist;
    }
    else
    {
        throw "UserNotLoggedInException";
    }
}

void TripService::BuildCheck()
{
    cout << "Built and runnable!" << endl;
}

#endif