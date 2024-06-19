"use strict"

import UserSession from './UserSession.js'
import TripDAO from './TripDAO.js'

class TripService {
    getTripsByUser(user) {
        let tripList = []
        let loggedUser = UserSession.getLoggedUser()
        let isFriend = false
        if (loggedUser != null) {
            let friends = user.getFriends()
            for (let i=0; i < friends.length; i++) {
                let friend = friends[i]
                if (friend == loggedUser) {
                    isFriend = true
                    break
                }
            }
            if (isFriend) {
                tripList = TripDAO.findTripsByUser(user)
            }
            return tripList
        } else {
            throw new Error('User not logged in.')
        }
    }
}

export default TripService
