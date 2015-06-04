#import <Foundation/Foundation.h>
#import "User.h"

@interface TripDAO : NSObject

+(NSArray*)findTripsByUser:(User*)user;

@end
