#include <list>
#include "packages/TripServiceSupport.h"

UserSession *UserSession::oneUserSession=0;

std::list<Trip> TripService::GetTripsByUser( User *user )
{
    std::list<Trip> triplist ;
    User* loggedUser = UserSession::GetInstance()->GetLoggedUser();
    bool isFriend = false;
    if ( loggedUser )
    {
        std::list<User>::iterator i;
        for( i = user->GetFriends().begin(); i != user->GetFriends().end(); ++i )
        {
            if ( *i == *loggedUser )
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
