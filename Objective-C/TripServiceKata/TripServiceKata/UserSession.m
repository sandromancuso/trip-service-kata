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

-(BOOL)IsUserLoggedIn:(User*)user
{
    [DependendClassCallDuringUnitTestException raise:@"Unit Test Exception" format:@"UserSession.IsUserLoggedIn() should not be called in an unit test"];
    return nil;
}


-(User*)GetLoggedUser
{
    [DependendClassCallDuringUnitTestException raise:@"Unit Test Exception" format:@"UserSession.GetLoggedUser() should not be called in an unit test"];
    
    return nil;
}

@end
