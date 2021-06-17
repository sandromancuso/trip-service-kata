#ifndef USERSESSION_H
#define USERSESSION_H

#include "User.h"

class UserSession
{
  public:
    inline static UserSession* GetInstance()
    {
        if (!oneUserSession)
        {
            oneUserSession = new UserSession();
        }
        return oneUserSession;
    }
    inline bool IsUserLoggedIn(User user)
    {
        throw "UserSession.IsUserLoggedIn() should not be called in an unit test";
    }
    inline User* GetLoggedUser()
    {
        throw "UserSession.GetLoggedUser() should not be called in an unit test";
    }

  private:
    static UserSession* oneUserSession;
    inline UserSession(){};
};

#endif