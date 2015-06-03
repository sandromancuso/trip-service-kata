#import "UserSession.h"
#import "User.h"
#import "DependendClassCallDuringUnitTestException.h"


@implementation UserSession

+ (UserSession*)sharedInstance
{
    static UserSession *_sharedInstance = nil;
    static dispatch_once_t oncePredicate;
    
    dispatch_once(&oncePredicate, ^{
        _sharedInstance = [[UserSession alloc] init];
    });
    return _sharedInstance;
}

-(BOOL)isUserLoggedIn:(User*)user
{
    [DependendClassCallDuringUnitTestException raise:@"Unit Test Exception" format:@"UserSession.IsUserLoggedIn() should not be called in an unit test"];
    return nil;
}


-(User*)getLoggedUser
{
    [DependendClassCallDuringUnitTestException raise:@"Unit Test Exception" format:@"UserSession.getLoggedUser() should not be called in an unit test"];
    
    return nil;
}

@end
