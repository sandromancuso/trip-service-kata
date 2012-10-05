from TripDOA import TripDAO
from UserSession import UserSession
from UserNotLoggedInException import UserNotLoggedInException

class TripServiceOriginal:
  def getTripsByUser(self, user):
    loggeduser = UserSession.getInstance().getLoggedUser()
    isFriend = False
    tripList = []
    if loggeduser:
      for friend in user.getFriends():
        if friend is user:
          isFriend = True
          break;
      if isFriend:
        tripList = TripDAO.findTripsByUser(user)
      return tripList
    else:
      raise UserNotLoggedInException()


