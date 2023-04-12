module TripServiceKata.UserSession

open System
open TripServiceKata.User

let GetLoggedUser: User option =
    raise (InvalidOperationException "GetLoggedUser() should not be called in an unit test")