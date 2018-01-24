import Foundation

enum UnitTestErrorType : Error
{
    case dependendClassCallDuringUnitTest
}

enum TripServiceErrorType : Error
{
    case userNotLoggedIn
}
