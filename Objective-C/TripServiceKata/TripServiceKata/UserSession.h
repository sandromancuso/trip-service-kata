#import <Foundation/Foundation.h>
#import "User.h"
@interface UserSession : NSObject


+ (UserSession*)sharedInstance;
- (BOOL)isUserLoggedIn:(User*)user;
- (User*)getLoggedUser;

@end
