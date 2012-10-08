#include <list>

class Trip
{
};

class User
{
public:
    inline User( int _id ):id(_id) {} ;
    
    inline std::list<User> GetFriends() { return friends; }
    inline void AddFriend( User user ) { friends.push_back( user ); }
    inline std::list<Trip> Trips() { return trips; }
    inline void AddTrip( Trip trip ) { trips.push_back( trip ); }

    inline bool operator==( User& other ) { return (other.id==id); }
private:
    int id;
    std::list<Trip> trips;
    std::list<User> friends;
};

class TripService
{
public:
    static std::list<Trip> GetTripsByUser( User user );
  
};

  
class UserSession;
UserSession *oneUserSession=0;

class UserSession
{
public:
    inline static UserSession* GetInstance()
    {
        if ( !oneUserSession ) { oneUserSession = new UserSession(); }
        return oneUserSession;    
    }
    
    inline bool IsUserLoggedIn( User user )
    {
        throw "UserSession.IsUserLoggedIn() should not be called in an unit test";
    }
    inline User* GetLoggedUser()
    {
        throw "UserSession.GetLoggedUser() should not be called in an unit test";
    }
    
private:
    inline UserSession() {};
};

class TripDAO
{
public:
    inline static std::list<Trip> FindTripsByUser(User user)
    {
        throw "TripDAO should not be invoked on an unit test.";
    }
};

