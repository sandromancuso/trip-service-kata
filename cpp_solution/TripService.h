#pragma once
#include <list>

class Trip
{
};

class User
{
public:
	inline User(int _id) :id(_id) {};

	inline std::list<User>& GetFriends() { return friends; }
	inline void AddFriend(User user) { friends.push_back(user); }
	inline std::list<Trip>& Trips() { return trips; }
	inline void AddTrip(Trip trip) { trips.push_back(trip); }

	inline bool operator==(const User& other) const  { return (other.id == id); }
private:
	int id;
	std::list<Trip> trips;
	std::list<User> friends;
};

class UserNotLoggedInException: public std::logic_error
{
public:
	using std::logic_error::logic_error;
//	UserNotLoggedInException:  logic_error("UserNotLoggedInException"){};

};

class TripDAO
{
public:
	inline static std::list<Trip> FindTripsByUser(User& user)
	{
		throw std::logic_error("TripDAO should not be invoked on an unit test.");
	}
};

class TripService
{
public:

	std::list<Trip> GetTripsByUser(User& user);
protected:
	virtual User* getLoggedInUser();
	virtual std::list<Trip> findTripsByUser(User& user);
};


class UserSession
{
public:
	inline static UserSession* GetInstance()
	{
		if (!oneUserSession) { oneUserSession = new UserSession(); }
		return oneUserSession;
	}

	inline bool IsUserLoggedIn(User user)
	{
		throw std::logic_error("UserSession.IsUserLoggedIn() should not be called in an unit test");
	}
	inline User* GetLoggedUser()
	{
		throw std::logic_error("UserSession.GetLoggedUser() should not be called in an unit test");
	}

private:
	static UserSession *oneUserSession;
	inline UserSession() {};
};
