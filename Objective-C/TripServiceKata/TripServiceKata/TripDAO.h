#import <Foundation/Foundation.h>
#import "User.h"

@interface TripDAO : NSObject

+(NSArray*)FindTripsByUser:(User*)user;

@end
