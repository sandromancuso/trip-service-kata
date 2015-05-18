Testing legacy code: Hard-wired dependencies
============================================

Code related to Sandro Mancuso's [Testing legacy code: Hard-wired dependencies][1] blog post. Try not reading the blog post before doing the exercise yourself.

What is it about?
-----------------

Provides an example of existing code that needs to be unit tested. But there is one rule:

> We can't change any existing code if not covered by tests. The only exception is if we need to change the code to add unit tests, but in this case, just automated refactorings (via IDE) are allowed. 

Although this is a very small piece of code, it has a lot of the problems that we find in legacy code. 

Details
-------
Since the original is from Java, there is both a mechanical translation and an idiomatic python translation. The idiomatic, single-file translation is [tripservice.py][2], while the mechanical translation can be found in the [tripservice_mechanical directory][3].

It is recommended that you use the idiomatic translation when giving trying this kata in python. You should attempt to refactor by unit testing it following the rule above.

For future comparisions, when you are done, you can always check [tripservice_original.py][4]

[1]: http://craftedsw.blogspot.com/2011/07/testing-legacy-hard-wired-dependencies.html "Testing legacy code: Hard-wired dependencies blog post"
[2]: https://github.com/bricef/trip-service-kata/blob/master/python/tripservice.py "tripservice.py"
[3]: https://github.com/bricef/trip-service-kata/blob/master/python/tripservice_mechanical "tripservice mechanical translation from original Java Code"
[4]: https://github.com/bricef/trip-service-kata/blob/master/python/tripservice_original.py "tripservice_original.py"
