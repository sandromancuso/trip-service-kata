package org.craftedsw.tripservicekata.user

import org.craftedsw.tripservicekata.exception.CollaboratorCallException

object UserSession extends UserSession {

	def getLoggedUser(): User = {
		throw new CollaboratorCallException(
			"UserSession.getLoggedUser() should not be called in an unit test");
	}

}

trait UserSession {

	def getLoggedUser(): User

}
