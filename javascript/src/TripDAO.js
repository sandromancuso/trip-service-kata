"use strict";

class TripDAO {

    static findTripsByUser(user) {
        throw new Error("TripDAO should not be invoked on an unit test.");
    }
}

module.exports = TripDAO;