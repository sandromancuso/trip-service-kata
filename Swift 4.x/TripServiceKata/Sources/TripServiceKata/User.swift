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
    private var userTrips:[Trip] = []
    private var friends:[User] = []
    
    func getFriends() -> [User]
    {
        return self.friends
    }
    
    func addFriend(friend:User)
    {
        self.friends.append(friend)
    }
    
    func trips() -> [Trip]
    {
        return self.userTrips
    }
    
    func addTrip(trip:Trip)
    {
        self.userTrips.append(trip)
    }
}