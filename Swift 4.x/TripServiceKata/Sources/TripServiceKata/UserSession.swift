//
//  UserSession.swift
//  TripServiceKata
//
//  Created by Alessandro Benvenuti on 21/02/2016.
//  Copyright © 2016 Alessandro Benvenuti. All rights reserved.
//

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
