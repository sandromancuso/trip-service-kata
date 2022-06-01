#ifndef TRIPDAO_H
#define TRIPDAO_H

#include "Trip.h"
#include "User.h"
#include <iostream>

using namespace std;

class TripDAO
{
  public:
    inline static list<Trip> FindTripsByUser(User* user)
    {
        throw "TripDAO should not be invoked on an unit test.";
    }
};

#endif