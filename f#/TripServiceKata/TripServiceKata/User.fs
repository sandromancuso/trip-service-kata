module TripServiceKata.User

open TripServiceKata.Trip

type User = {
    Friends: User list
    Trips: Trip list
}

