<?php
class UserSession {

	private static $userSession;
	
	public static function getInstance() {
            if (self::$userSession == null) {
                self::$userSession = new UserSession();
            }
            return self::$userSession;
	}

	public function isUserLoggedIn(User $user) {
		throw new DependendClassCallDuringUnitTestException(
				"UserSession.isUserLoggedIn() should not be called in an unit test");
	}

	public function getLoggedUser() {
		throw new DependendClassCallDuringUnitTestException(
				"UserSession.getLoggedUser() should not be called in an unit test");
	}

}
?>
