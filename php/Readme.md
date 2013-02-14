# PHP 

In order to run the unit tests you need to declare usage of php/tests/bootstrap.php

##Coverage
If your IDE doesn't handle it you can launch it from the command line : 
Given you are in .php/ 

        phpunit --bootstrap test/bootstrap.php  --coverage-html report ./test/

Then visulize 

        report/src_tripservicekata_trip_TripService.class.php.html 
in a browser

Enjoy

