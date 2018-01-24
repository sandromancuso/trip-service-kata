import Foundation

class TripService
{
    func getTripsByUser(_ user:User) throws -> [Trip]?
    {
        var tripList:[Trip]? = nil
        let loggedUser = try! UserSession.sharedInstance.getLoggedUser()
        
        var isFriend = false
        
        if let loggedUser = loggedUser {
            for friend in user.getFriends() {
                if friend == loggedUser {
                    isFriend = true
                    break
                }
            }
            if isFriend {
                tripList = try! TripDAO.findTripsByUser(user)
            }
            return tripList
        }
        else {
            throw TripServiceErrorType.userNotLoggedIn
        }
    }
}
