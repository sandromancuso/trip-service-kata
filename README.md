Trip Service Kata
=================

Kata for legacy code hands-on session. The objective is to test and refactor the legacy `TripService` class.

Testing legacy code: Hard-wired dependencies
--------------------------------------------

The code is related to my [Testing legacy code: Hard-wired dependencies](http://codurance.com/2011/07/16/testing-legacy-hard-wired-dependencies/) blog post. Try not reading the blog post before doing the exercise yourself.

It provides an example of existing code that needs to be unit tested. But there is one rule:

> We can't change any existing code if not covered by tests. The only exception is if we need to change the code to add unit tests, but in this case, just automated refactoring (via IDE) is allowed.

Although this is a very small piece of code, it has a lot of the problems that we find in legacy code.

The end result should be well-crafted code that expresses the domain.

You can watch the video with my solution. Although quite long, I explain my whole thought process while writing tests, how I break dependencies, the reasons for refactoring and re-designing the code (tests and production code), and why certain steps are important. I also cover how often I commit and why I do it.

The video is full of tips and tricks that can be used in any language.

https://www.youtube.com/watch?v=_NnElPO5BU0
