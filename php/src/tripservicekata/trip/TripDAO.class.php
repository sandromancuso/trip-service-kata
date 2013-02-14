<?php
class TripDAO {

    public static function findTripsByUser(User $user) {
        throw new DependendClassCallDuringUnitTestException("TripDAO should not be invoked on an unit test.");
    }
}
?>