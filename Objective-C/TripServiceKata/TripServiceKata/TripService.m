#import "TripService.h"
#import "User.h"
#import "UserSession.h"
#import "TripDAO.h"
#import "UserNotLoggedInException.h"

@implementation TripService

- (NSArray*)GetTripsByUser:(User*)user
{
    NSArray* tripList = [NSArray array];
    User* loggedUser = [[UserSession sharedInstance] getLoggedUser];
    
    BOOL isFriend = NO;
    
    if(loggedUser != nil)
    {
        for (User* friend in [user getFriends])
        {
            if(friend == loggedUser)
            {
                isFriend = YES;
                break;
            }
        }
        if(isFriend)
        {
            tripList = [TripDAO findTripsByUser:user];
        }
        
        return tripList;
    }
    else
    {
        [UserNotLoggedInException raise:@"Unit Test Exception" format:@""];
    }
    return  nil;
}

@end
