#import <Foundation/Foundation.h>
#import "User.h"
@interface UserSession : NSObject


+ (UserSession*)sharedInstance;
-(BOOL)IsUserLoggedIn:(User*)user;
-(User*)GetLoggedUser;

@end
