module TripServiceKata.Trip.TripService

open TripServiceKata
open TripServiceKata.User
open TripServiceKata.Trip.TripServiceDAO

exception UserNotLoggedInException

let GetTripsByUser (user: User): Trip list =
    let mutable tripList = []
    let loggedInUser = UserSession.GetLoggedUser
    let mutable friend = None
    if (Option.isSome loggedInUser)
    then
        for f in user.Friends do
            if f = Option.get loggedInUser
            then
                friend <- Some f
        if (Option.isSome friend)
        then
            tripList <- FindTripsByUser (Option.get friend)
        tripList
    else
        raise UserNotLoggedInException
