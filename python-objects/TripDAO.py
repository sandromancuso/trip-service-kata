from DependendClassCallDuringUnitTestException import DependendClassCallDuringUnitTestException


class TripDAO(object):
    @staticmethod
    def find_trips_by_user(user):
        raise DependendClassCallDuringUnitTestException("TripDAO should not be invoked on an unit test.")
