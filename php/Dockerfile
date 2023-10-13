FROM php:7-cli-alpine
LABEL authors="Mauro Chojrin"

RUN apk update && apk upgrade

RUN mkdir "/app/"

COPY . /app
RUN wget https://raw.githubusercontent.com/composer/getcomposer.org/76a7060ccb93902cd7576b67264ad91c8a2700e2/web/installer -O - -q | php -- --quiet && \
    mv composer.phar /usr/local/bin/composer

RUN apk add --no-cache --virtual .build-dependencies $PHPIZE_DEPS \
    && pecl install xdebug-3.1.0 \
    && docker-php-ext-enable xdebug \
    && pecl clear-cache \
    && apk del .build-dependencies

RUN echo "xdebug.mode = coverage" >> /usr/local/etc/php/conf.d/docker-php-ext-xdebug.ini

WORKDIR /app