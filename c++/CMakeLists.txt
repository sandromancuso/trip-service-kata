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