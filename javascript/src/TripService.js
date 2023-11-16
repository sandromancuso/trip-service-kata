"use strict";

const UserSession = require('./UserSession');
const TripDAO = require('./TripDAO');

class TripService {
    validateLoggedUser(loggedUser) {
        if(!loggedUser) {
            throw new Error('Usuário não logado')
        };
    };
    
    isFriendOfLoggedUser(user, loggedUser) {
        const friends = user.getFriends()
        return friends.find((friend) => friend === loggedUser)
    }

    getTripsByUser(user) {
        let loggedUser = UserSession.getLoggedUser();
        this.validateUser(loggedUser)

        const isFriend = isFriendOfLoggedUser(user, loggedUser)
        isFriend ? TripDAO.findTripsByUser(user) : [];
    }
}

module.exports = TripService
