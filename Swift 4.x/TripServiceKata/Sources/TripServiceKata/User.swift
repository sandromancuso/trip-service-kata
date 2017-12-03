//
//  User.swift
//  TripServiceKata
//
//  Created by Alessandro Benvenuti on 21/02/2016.
//  Copyright © 2016 Alessandro Benvenuti. All rights reserved.
//

import Foundation

func ==(lhs: User, rhs: User) -> Bool
{
    return lhs === rhs
}

class User : Equatable
{
    fileprivate var userTrips:[Trip] = []
    fileprivate var friends:[User] = []
    
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
