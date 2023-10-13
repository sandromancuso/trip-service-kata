# PHP

In order to perform the kata, first of all you will need to install all of the dependencies. This can be done using
composer (standing from the *"php"* directory")
```shell
wget http://getcomposer.org/composer.phar
php composer.phar install
```

Next, to execute the unit tests you need run this from the *php* directory
```shell
php bin/phpunit
```

## Coverage

When running the tests a coverage report should be generated automatically in simple text format and html report. If you want
to visualize it from the browser you can open the `coverage/report/index.html` file in a browser after running the tests.

Enjoy

# Note

This application is designed to work with PHP ~7.0. If you don't have this installed locally, a Dockerfile is provided. Assuming you have [Docker](https://docs.docker.com/get-docker/) installed, use the following instructions to get things going:

```shell
docker build . -t php-trip-service
docker run -it -v $(pwd):/app php-trip-service:latest php composer.phar install
```

And to execute the tests:

```shell
docker run -it -v $(pwd):/app php-trip-service:latest php bin/phpunit
```

