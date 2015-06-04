#import <Foundation/Foundation.h>
#import "Trip.h"

@interface User : NSObject

-(NSArray*)getFriends;
-(void)addFriend:(User*)user;

-(NSArray*)trips;
-(void)addTrip:(Trip*)trip;

@end
