from TripDAO import TripDAO
from UserNotLoggedInException import UserNotLoggedInException
from UserSession import UserSession


class TripService(object):
    def get_trips_by_user(self, user):
        logged_user = UserSession.get_instance().get_logged_user()
        is_friend = False
        trip_list = []
        if logged_user:
            for friend in user.get_friends():
                if friend is logged_user:
                    is_friend = True
                    break
            if is_friend:
                trip_list = TripDAO.find_trips_by_user(user)
            return trip_list
        else:
            raise UserNotLoggedInException()
