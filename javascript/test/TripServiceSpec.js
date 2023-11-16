"use strict";

const assert = require("assert");
const TripService = require("../src/TripService");
const UserSession = require("../src/UserSession");
const TripDAO = require("../src/TripDAO");
const User = require("../src/User");

describe("Test Class TripService", () => {
  const originalGetLoggedUser = UserSession.getLoggedUser;

  beforeEach(() => {
    UserSession.getLoggedUser = originalGetLoggedUser;
  });

  it("should return an empty array when the user is not logged in", () => {
    UserSession.getLoggedUser = () => null;
    const tripService = new TripService();

    assert.throws(
      () => {
        tripService.getTripsByUser(new User());
      },
      Error,
      "User not logged in."
    );
  });

  it("should return an empty array for a logged-in user who is not a friend", () => {
    const user = new User();
    const loggedUser = new User();
    const tripService = new TripService();

    UserSession.getLoggedUser = () => loggedUser;
    TripDAO.findTripsByUser = () => [];

    user.getFriends = () => [];

    const trips = tripService.getTripsByUser(user);

    assert.deepStrictEqual(trips, []);
  });

  it("should return trips when the user is a friend", () => {
    const user = new User();
    const loggedUser = new User();
    const tripService = new TripService();
    const trips = ["Trip1", "Trip2"];

    UserSession.getLoggedUser = () => loggedUser;
    user.getFriends = () => [loggedUser];
    TripDAO.findTripsByUser = () => trips;

    const result = tripService.getTripsByUser(user);

    assert.deepStrictEqual(result, trips);
  });
});
