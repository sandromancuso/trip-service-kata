//
//  TripService.swift
//  TripServiceKata
//
//  Created by Alessandro Benvenuti on 21/02/2016.
//  Copyright © 2016 Alessandro Benvenuti. All rights reserved.
//

import Foundation

class TripService
{
    func GetTripsByUser(user:User) throws -> [Trip]?
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
            throw TripServiceErrorType.UserNotLoggedIn
        }
    }
}