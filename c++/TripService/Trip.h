#ifndef TRIP_H
#define TRIP_H

#include <cstring>

class Trip
{
public:
    explicit Trip(const char *destination) : destination(destination) {}

    bool operator==(const Trip &rhs) const {
        return strcmp(destination, rhs.destination) == 0;
    }

    bool operator!=(const Trip &rhs) const {
        return strcmp(destination, rhs.destination) != 0;;
    }

private:
    const char * destination;
};

#endif
