Testing legacy code: Hard-wired dependencies
============================================

Code related to my [Testing legacy code: Hard-wired dependencies][1] blog post. Try not reading the blog post before doing the exercise yourself.

What is it about?
-----------------

Provides an example of existing code that needs to be unit tested. But there is one rule:

> We can't change any existing code if not covered by tests. The only exception is if we need to change the code to add unit tests, but in this case, just automated refactorings (via IDE) are allowed. 

Although this is a very small piece of code, it has a lot of the problems that we find in legacy code. 

Details
-------

If you want to give it a go, the starting point is [TripServiceTest.java][3] and [TripService.java][4]. Try unit testing it following the rule above.

For future comparisions, when you are done, you can always check [TripService_Original.java][2]

[1]: http://codurance.com/2011/07/16/testing-legacy-hard-wired-dependencies/ "Testing legacy code: Hard-wired dependencies blog post"
[2]: https://github.com/sandromancuso/trip-service-kata/blob/master/java/trip-service-kata/src/main/java/org/craftedsw/tripservicekata/TripService_Original.java "TripService_Original.java"
[3]: https://github.com/sandromancuso/trip-service-kata/blob/master/java/trip-service-kata/src/test/java/org/craftedsw/tripservicekata/TripServiceTest.java "TripServiceTest.java"
[4]: https://github.com/sandromancuso/trip-service-kata/blob/master/java/trip-service-kata/src/main/java/org/craftedsw/tripservicekata/trip/TripService.java "TripService.java"
