//
//  UnitTestErrorType.swift
//  TripServiceKata
//
//  Created by Alessandro Benvenuti on 21/02/2016.
//  Copyright © 2016 Alessandro Benvenuti. All rights reserved.
//

import Foundation

enum UnitTestErrorType : ErrorType
{
    case DependendClassCallDuringUnitTest
}

enum TripServiceErrorType : ErrorType
{
    case UserNotLoggedIn
}