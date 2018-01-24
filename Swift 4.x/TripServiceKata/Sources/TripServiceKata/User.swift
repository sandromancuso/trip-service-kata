import Foundation

func ==(lhs: User, rhs: User) -> Bool
{
    return lhs === rhs
}

class User : Equatable
{
    private var userTrips:[Trip] = []
    private var friends:[User] = []
    
    func getFriends() -> [User]
    {
        return self.friends
    }
    
    func addFriend(_ friend:User)
    {
        self.friends.append(friend)
    }
    
    func trips() -> [Trip]
    {
        return self.userTrips
    }
    
    func addTrip(_ trip:Trip)
    {
        self.userTrips.append(trip)
    }
}
