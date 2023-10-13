FROM php:7-cli-alpine
LABEL authors="Mauro Chojrin"

RUN mkdir "/app/"

COPY . /app
RUN wget https://raw.githubusercontent.com/composer/getcomposer.org/76a7060ccb93902cd7576b67264ad91c8a2700e2/web/installer -O - -q | php -- --quiet && \
    mv composer.phar /usr/local/bin/composer

WORKDIR /app