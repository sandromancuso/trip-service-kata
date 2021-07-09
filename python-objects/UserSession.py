from DependendClassCallDuringUnitTestException import DependendClassCallDuringUnitTestException


class UserSession(object):
    def __new__(cls):
        if not hasattr(cls, '_instance'):
            cls._instance = super(UserSession, cls).__new__(cls)
        return cls._instance

    @staticmethod
    def get_instance():
        return UserSession()

    def is_user_logged_in(self, user):
        raise DependendClassCallDuringUnitTestException(
            "UserSession.isUserLoggedIn() should not be called in an unit test")

    def get_logged_user(self):
        raise DependendClassCallDuringUnitTestException(
            "UserSession.getLoggedUser() should not be called in an unit test")
