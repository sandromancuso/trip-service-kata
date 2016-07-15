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

If you want to give it a go, the starting point is [trip/trip_service.rb] and [tests/trip_service_tests.rb] . Try unit testing it following the rule above.

[1]: http://craftedsw.blogspot.com/2011/07/testing-legacy-hard-wired-dependencies.html "Testing legacy code: Hard-wired dependencies blog post"