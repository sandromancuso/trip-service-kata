#ifndef USER_H
#define USER_H

#include <iostream>
#include <list>

using namespace std;

class User
{
  public:
    inline User(int _id) : id(_id){};
    inline list<User>& GetFriends()
    {
        return friends;
    }
    inline void AddFriend(User user)
    {
        friends.push_back(user);
    }
    inline list<Trip>& Trips()
    {
        return trips;
    }
    inline void AddTrip(Trip trip)
    {
        trips.push_back(trip);
    }
    inline bool operator==(User& other)
    {
        return (other.id == id);
    }

  private:
    int id;
    list<Trip> trips;
    list<User> friends;
};

#endif