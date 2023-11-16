"use strict";

const UserSession = require("./UserSession");
const TripDAO = require("./TripDAO");

class TripService {
  getTripsByUser(user) {
    const loggedUser = UserSession.getLoggedUser();
    this.validateUser(loggedUser);

    const isFriend = this.checkIfUserIsFriend(user, loggedUser);

    if (isFriend) {
      return TripDAO.findTripsByUser(user);
    } else {
      return [];
    }
  }

  validateUser(loggedUser) {
    if (!loggedUser) {
      throw new Error("User not logged in.");
    }
  }

  checkIfUserIsFriend(user, loggedUser) {
    const friends = user.getFriends();
    return friends.some((friend) => friend === loggedUser);
  }
}

module.exports = TripService;
