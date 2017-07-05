package org.craftedsw.tripservicekata.user

object EmptySession extends UserSession {
  override def getLoggedUser(): User = null
}
