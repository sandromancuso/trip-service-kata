"use strict"

class UserSession {
    getLoggedUser() {
        throw new Error('UserSession.getLoggedUser() should not be called in an unit test')
    }

}

export default new UserSession()
