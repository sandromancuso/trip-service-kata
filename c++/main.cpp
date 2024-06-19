#include "TripService/TripService.h"
#include "TripService/User.h"
#include <gtest/gtest.h>

TEST(TripServiceShould, do_something)
{
    auto *tripService = new TripService();
    try {
        tripService->GetTripsByUser(nullptr);
    } catch (const char * exception) {
        FAIL() << exception;
    }
}
