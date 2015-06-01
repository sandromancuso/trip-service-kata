#import "User.h"

@interface User()
    @property (nonatomic, strong) NSMutableArray* trips;
    @property (nonatomic, strong) NSMutableArray* friends;
@end

@implementation User

- (instancetype) init
{
    if([super init])
    {
        self.trips = [NSMutableArray array];
        self.friends = [NSMutableArray array];
    }
    
    return self;
}

-(NSArray*)GetFriends
{
    return self.friends;
}

-(void)AddFriend:(User*)user
{
    [self.friends addObject:user];
}

-(NSArray*)Trips
{
    return self.trips;
}

-(void)AddTrip:(Trip*)trip
{
    [self.trips addObject:trip];
}

@end
