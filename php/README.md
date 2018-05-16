# PHP

In order to perform the kata, first of all you will need to install all of the dependencies. This can be done using
composer (standing from the *"php"* directory")

```shell
wget http://getcomposer.org/composer.phar
php composer.phar install
```

Next, to execute the unit tests you need run this from the *php* directory

    php bin/phpunit

## Coverage

When running the tests a coverage report should be generated automatically in simple text format and html report.

If you want to visualize it from the browser you can open

    open coverage/report/index.html

in a browser after running the tests.

Enjoy

