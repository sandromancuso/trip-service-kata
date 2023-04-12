module TripServiceKata.Trip.TripServiceDAO

open System
open TripServiceKata.Trip
open TripServiceKata.User

let FindTripsByUser (user: User): Trip list =
    raise (InvalidOperationException "FindTripsByUser should not be invoked on an unit test.")