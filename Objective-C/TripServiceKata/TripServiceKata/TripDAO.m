#import "TripDAO.h"
#import "DependendClassCallDuringUnitTestException.h"

@implementation TripDAO

+(NSArray*)findTripsByUser:(User*)user
{
    [DependendClassCallDuringUnitTestException raise:@"Unit Test Exception" format:@"TripDAO should not be invoked on an unit test."];
    
    return nil;
}



@end
