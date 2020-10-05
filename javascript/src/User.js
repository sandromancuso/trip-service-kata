"use strict"

export default class User {
    constructor(friends = []) {
        this.friends = friends
    }

    getFriends() {
        return this.friends
    }
}