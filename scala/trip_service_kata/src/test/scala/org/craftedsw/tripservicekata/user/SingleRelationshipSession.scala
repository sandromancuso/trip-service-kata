package org.craftedsw.tripservicekata.user

object SingleRelationshipSession extends UserSession {

  val loggedInUser = new User
  val loggedInUserFriend = new User

  loggedInUser.friendList += loggedInUserFriend
  loggedInUserFriend.friendList += loggedInUser

  override def getLoggedUser(): User = loggedInUser

}
