//
//  UnitTestErrorType.swift
//  TripServiceKata
//
//  Created by Alessandro Benvenuti on 21/02/2016.
//  Copyright © 2016 Alessandro Benvenuti. All rights reserved.
//

import Foundation

enum UnitTestErrorType : Error
{
    case dependendClassCallDuringUnitTest
}

enum TripServiceErrorType : Error
{
    case userNotLoggedIn
}
