# Trip Service Kata in [ABAP](http://scn.sap.com/community/abap/)

## Prerequisite

Access to SAP NetWeaver server with at least ABAP 7.40

## Installation

Assuming you have a proper developer key set up, run SE38
* create a new Module Pool (type M) program as a Local Object
* paste the raw code from [YY_PAO_TRIP_SERVICE.abap](https://raw.githubusercontent.com/brehberg/trip-service-kata/master/abap/YY_PAO_TRIP_SERVICE.abap)
* save (Ctrl-S) and activate (Ctrl-F3) the program

## Running Tests

From the menus choose Program -> Execute -> Unit Tests (Ctrl+Shift+F10) 

## Requirements Specification
Imagine building a social networking website for travellers
* users need to be logged in to see the content
* users need to be a friend to see someone else's trips

You cannot change production code if not covered by tests
* basic refactorings are allowed, but only if needed to write tests

Start testing from shortest to deepest branch
Start refactoring from deepest to shortest branch

Give it a go, the starting point is the LTC_TRIP_SERVICE_TEST class
