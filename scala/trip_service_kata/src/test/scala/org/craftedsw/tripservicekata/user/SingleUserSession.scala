package org.craftedsw.tripservicekata.user

object SingleUserSession extends UserSession {

  val onlyUser = new User

  override def getLoggedUser(): User = onlyUser

}