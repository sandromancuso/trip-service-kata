cmake_minimum_required(VERSION 3.20.3)

project(TripServiceKata VERSION 0.1.0)

set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED True)

set(
  SOURCES
  TripService/Trip.h
  TripService/TripDAO.h
  TripService/TripService.h
  TripService/TripService.cpp
  TripService/User.h
  TripService/UserSession.h
  main.cpp
)

add_executable(TripServiceKata "${SOURCES}")

include(FetchContent)
FetchContent_Declare(
        googletest
        URL https://github.com/google/googletest/archive/03597a01ee50ed33e9dfd640b249b4be3799d395.zip
)

FetchContent_MakeAvailable(googletest)

target_link_libraries(TripServiceKata gtest gtest_main gmock)
include(GoogleTest)
gtest_discover_tests(TripServiceKata)
