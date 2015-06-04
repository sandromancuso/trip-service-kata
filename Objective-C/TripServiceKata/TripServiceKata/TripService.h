//
//  TripService.h
//  TripServiceKata
//
//  Created by Ana Nogal on 01/06/2015.
//  Copyright (c) 2015 Codurance. All rights reserved.
//

#import <Foundation/Foundation.h>

@class User;

@interface TripService : NSObject
- (NSArray*)GetTripsByUser:(User*)user;
@end
