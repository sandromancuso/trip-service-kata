import Foundation

class UserSession
{
    static var sharedInstance:UserSession = UserSession()
    
    func isUserLoggedIn(_ user:User) throws -> Bool
    {
        throw UnitTestErrorType.dependendClassCallDuringUnitTest
    }
    
    func getLoggedUser() throws -> User?
    {
        throw UnitTestErrorType.dependendClassCallDuringUnitTest
    }
}
