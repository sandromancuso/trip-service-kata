<?php

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author johan
 */
// TODO: check include path
//ini_set('include_path', ini_get('include_path'));

// put your code here

// Or, using an anonymous function as of PHP 5.3.0
spl_autoload_register(function ($class) {
    include_once __DIR__.'/../src/tripservicekata/trip/TripService.class.php';
    include_once __DIR__.'/../src/tripservicekata/trip/TripDao.class.php';
    include_once __DIR__.'/../src/tripservicekata/trip/Trip.class.php';
    include_once __DIR__.'/../src/tripservicekata/exception/DependendClassCallDuringUnitTestException.class.php';
    include_once __DIR__.'/../src/tripservicekata/exception/UserNotLoggedInException.class.php';
    include_once __DIR__.'/../src/tripservicekata/user/UserSession.class.php';
    include_once __DIR__.'/../src/tripservicekata/user/User.class.php';
});

?>
