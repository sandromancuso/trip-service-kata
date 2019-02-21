package trip

import (
    "errors"
    "user"
)

type TripService struct {
}

func (s *TripService) GetTripsByUser(u *user.User) ([]*Trip, error) {
    var trips []*Trip
    loggedUser := user.GetLoggedUser()
    isFriend := false
    if loggedUser != nil {
        for _, friend := range u.GetFriends() {
            if friend == loggedUser {
                isFriend = true
                break
            }
        }
        if isFriend {
            trips = findTripsByUser(u)
        }
        return trips, nil
    } else {
        return trips, errors.New("user not logged in")
    }
}