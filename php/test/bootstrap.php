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
    $baseDir = __DIR__.'/../src/tripservicekata/';
    include_once $baseDir.'trip/TripService.class.php';
    include_once $baseDir.'trip/TripDao.class.php';
    include_once $baseDir.'trip/Trip.class.php';
    include_once $baseDir.'exception/DependendClassCallDuringUnitTestException.class.php';
    include_once $baseDir.'exception/UserNotLoggedInException.class.php';
    include_once $baseDir.'user/UserSession.class.php';
    include_once $baseDir.'user/User.class.php';
});

?>
