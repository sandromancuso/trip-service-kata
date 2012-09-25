package org.craftedsw.tripservicekata.user;

import org.craftedsw.tripservicekata.exception.DependendClassCallDuringUnitTestException;

public class UserSession {

	private static final UserSession userSession = new UserSession();
	
	private UserSession() {
	}
	
	public static UserSession getInstance() {
		return userSession;
	}

	public boolean isUserLoggedIn(User user) {
		throw new DependendClassCallDuringUnitTestException(
				"UserSession.isUserLoggedIn() should not be called in an unit test");
	}

	public User getLoggedUser() {
		throw new DependendClassCallDuringUnitTestException(
				"UserSession.getLoggedUser() should not be called in an unit test");
	}

}
