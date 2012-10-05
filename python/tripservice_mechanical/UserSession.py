from DependendClassCallDuringUnitTestException import DependendClassCallDuringUnitTestException

class UserSession:
  _instance = None
  def __new__(cls, *args, **kwargs):
    if not cls._instance:
      cls._instance = super(Singleton, cls).__new__(cls, *args, **kwargs)
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

