<?php

namespace TripServiceKata\User;

use TripServiceKata\Exception\DependendClassCallDuringUnitTestException;

class UserSession
{
    /**
     * @var UserSession
     */
    private static $userSession;

    /**
     * @return UserSession
     */
    public static function getInstance()
    {
        if (null === static::$userSession) {
            static::$userSession = new UserSession();
        }

        return static::$userSession;
    }

    public function isUserLoggedIn(User $user)
    {
        throw new DependendClassCallDuringUnitTestException(
            'UserSession.isUserLoggedIn() should not be called in an unit test'
        );
    }

    public function getLoggedUser()
    {
        throw new DependendClassCallDuringUnitTestException(
            'UserSession.getLoggedUser() should not be called in an unit test'
        );
    }

}
