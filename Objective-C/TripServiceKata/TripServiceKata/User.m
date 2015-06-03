#import "User.h"

@interface User()
    @property (nonatomic, strong) NSMutableArray*userTrips;
    @property (nonatomic, strong) NSMutableArray* friends;
@end

@implementation User

- (instancetype) init
{
    if([super init])
    {
        self.userTrips = [NSMutableArray array];
        self.friends = [NSMutableArray array];
    }
    
    return self;
}

-(NSArray*)getFriends
{
    return self.friends;
}

-(void)addFriend:(User*)user
{
    [self.friends addObject:user];
}

-(NSArray*)trips
{
    return self.userTrips;
}

-(void)addTrip:(Trip*)trip
{
    [self.userTrips addObject:trip];
}

@end
