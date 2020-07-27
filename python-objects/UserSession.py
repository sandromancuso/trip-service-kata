from DependendClassCallDuringUnitTestException import DependendClassCallDuringUnitTestException

class UserSession:

  def __new__(cls):
    if not hasattr(cls, '_instance'):
      cls._instance = super(UserSession, cls).__new__(cls)
    return cls._instance
  
  @staticmethod
  def getInstance():
    return UserSession()

  def isUserLoggedIn(self, user):
    raise DependendClassCallDuringUnitTestException(
      "UserSession.isUserLoggedIn() should not be called in an unit test"
    )

  def getLoggedUser(self):
    raise DependendClassCallDuringUnitTestException(
      "UserSession.getLoggedUser() should not be called in an unit test"
    )

