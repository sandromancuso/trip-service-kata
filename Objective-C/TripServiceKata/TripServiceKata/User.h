#import <Foundation/Foundation.h>
#import "Trip.h"

@interface User : NSObject

-(NSArray*)GetFriends;
-(void)AddFriend:(User*)user;

-(NSArray*)Trips;
-(void)AddTrip:(Trip*)trip;

@end
