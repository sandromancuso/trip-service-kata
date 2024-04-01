<?php

namespace TripServiceKata\User;

use TripServiceKata\Exception\DependentClassCalledDuringUnitTestException;

class UserSession
{
    private static UserSession $userSession;

    public static function getInstance(): UserSession
    {
        if (null === static::$userSession) {
            static::$userSession = new UserSession();
        }

        return static::$userSession;
    }

    public function isUserLoggedIn(User $user)
    {
        throw new DependentClassCalledDuringUnitTestException(
            'UserSession.isUserLoggedIn() should not be called in an unit test'
        );
    }

    public function getLoggedUser()
    {
        throw new DependentClassCalledDuringUnitTestException(
            'UserSession.getLoggedUser() should not be called in an unit test'
        );
    }

}
