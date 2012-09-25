Testing legacy code: Hard-wired dependencies
============================================

Code related to my [Testing legacy code: Hard-wired dependencies][1] blog post

What is it about?
-----------------

Provides an example of existing code that needs to be unit tested. But there is one rule:

> We can't change any existing code if not covered by tests. The only exception is if we need to change the code to add unit tests, but in this case, just automated refactorings (via IDE) are allowed. 

Although this is a very small piece of code, it has a lot of the problems that we find in legacy code. 

Details
-------

If you want to give it a go, the starting point is [TripService_Original.java][2]. Try unit testing it following the rule above.

My solution was [TripServiceTest.java][3] and [TripSerivce.java][4]

[1]: http://craftedsw.blogspot.com/2011/07/testing-legacy-hard-wired-dependencies.html "Testing legacy code: Hard-wired dependencies blog post"
[2]: https://github.com/sandromancuso/testing_legacy_code/blob/master/src/main/java/org/craftedsw/harddependencies/TripService_Original.java "TripService_Original.java"
[3]: https://github.com/sandromancuso/testing_legacy_code/blob/master/src/test/java/org/craftedsw/harddependencies/TripServiceTest.java "TripServiceTest.java"
[4]: https://github.com/sandromancuso/testing_legacy_code/blob/master/src/main/java/org/craftedsw/harddependencies/trip/TripService.java "TripService.java"
