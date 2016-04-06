*&---------------------------------------------------------------------*
*&   Trip Service Requirements Specification
*&---------------------------------------------------------------------*
*&
*&  Imagine building a social networking website for travellers
*&    - users need to be logged in to see the content
*&    - users need to be a friend to see someone else's trips
*&
*&  You cannot change production code if not covered by tests
*&    - basic refactorings are allowed, but only if needed to write tests
*&
*&  Start testing from shortest to deepest branch
*&  Start refactoring from deepest to shortest branch
*&
*&  Give it a go, the starting point is the LTC_TRIP_SERVICE_TEST class

PROGRAM yy_pao_trip_service.


*& Production Code - Exceptions
CLASS lcx_user_not_logged_in DEFINITION FINAL INHERITING FROM cx_static_check.
ENDCLASS.

CLASS lcx_collaborator_call DEFINITION FINAL INHERITING FROM cx_dynamic_check.
  PUBLIC SECTION.
    METHODS:
      constructor
        IMPORTING iv_text TYPE string,
      get_text REDEFINITION.
  PRIVATE SECTION.
    DATA mv_text TYPE string.
ENDCLASS.

CLASS lcx_collaborator_call IMPLEMENTATION.
  METHOD constructor.
    super->constructor( ).
    mv_text = iv_text.
  ENDMETHOD.
  METHOD get_text.
    result = mv_text.
  ENDMETHOD.
ENDCLASS.


*& Production Code - Trips
CLASS lcl_user DEFINITION DEFERRED.

CLASS lcl_trip DEFINITION FINAL.
  PUBLIC SECTION.
    TYPES:
      tt_trip TYPE STANDARD TABLE OF REF TO lcl_trip WITH EMPTY KEY.
ENDCLASS.

CLASS lcl_trip_service DEFINITION FINAL.
  PUBLIC SECTION.
    METHODS:
      get_trips_by_user
        IMPORTING io_user TYPE REF TO lcl_user
        RETURNING VALUE(rt_trips) TYPE lcl_trip=>tt_trip
        RAISING lcx_user_not_logged_in.
ENDCLASS.

CLASS lcl_trip_dao DEFINITION FINAL.
  PUBLIC SECTION.
    CLASS-METHODS:
      find_trips_by_user
        IMPORTING io_user TYPE REF TO lcl_user
        RETURNING VALUE(rt_trips) TYPE lcl_trip=>tt_trip.
ENDCLASS.

CLASS lcl_trip_dao IMPLEMENTATION.
  METHOD find_trips_by_user.
    RAISE EXCEPTION TYPE lcx_collaborator_call
      EXPORTING iv_text = |lcl_trip_dao should not be invoked during unit test|.
  ENDMETHOD.
ENDCLASS.


*& Production Code - Users
CLASS lcl_user DEFINITION FINAL.
  PUBLIC SECTION.
    TYPES:
      tt_user TYPE STANDARD TABLE OF REF TO lcl_user WITH EMPTY KEY.
    METHODS:
      add_friend
        IMPORTING iv_user TYPE REF TO lcl_user,
      add_trip
        IMPORTING iv_trip TYPE REF TO lcl_trip,
      friends
        RETURNING VALUE(rt_users) TYPE tt_user,
      trips
        RETURNING VALUE(rt_trips) TYPE lcl_trip=>tt_trip.
  PRIVATE SECTION.
    DATA:
      mt_trips   TYPE lcl_trip=>tt_trip,
      mt_friends TYPE tt_user.
ENDCLASS.

CLASS lcl_user_session DEFINITION FINAL CREATE PRIVATE.
  PUBLIC SECTION.
    CLASS-METHODS:
      class_constructor,
      instance
        RETURNING VALUE(ro_value) TYPE REF TO lcl_user_session.
    METHODS:
      logged_user
        RETURNING VALUE(ro_value) TYPE REF TO lcl_user.
  PRIVATE SECTION.
    CLASS-DATA:
      go_user_session TYPE REF TO lcl_user_session.
ENDCLASS.

CLASS lcl_user IMPLEMENTATION.
  METHOD add_friend.
    APPEND iv_user TO mt_friends.
  ENDMETHOD.
  METHOD add_trip.
    APPEND iv_trip TO mt_trips.
  ENDMETHOD.
  METHOD friends.
    rt_users = mt_friends.
  ENDMETHOD.
  METHOD trips.
    rt_trips = mt_trips.
  ENDMETHOD.
ENDCLASS.

CLASS lcl_user_session IMPLEMENTATION.
  METHOD class_constructor.
    go_user_session = NEW #( ).
  ENDMETHOD.
  METHOD instance.
    ro_value = go_user_session.
  ENDMETHOD.
  METHOD logged_user.
    RAISE EXCEPTION TYPE lcx_collaborator_call
      EXPORTING iv_text = |lcl_user_session->logged_user() should not be called during unit test|.
  ENDMETHOD.
ENDCLASS.


*& Production Code - To be tested and refactored
CLASS lcl_trip_service IMPLEMENTATION.

  METHOD get_trips_by_user.
    DATA(lt_trip_list) = VALUE lcl_trip=>tt_trip( ).
    DATA(lo_logged_user) = lcl_user_session=>instance( )->logged_user( ).
    DATA(lv_is_friend) = abap_false.
    IF lo_logged_user IS BOUND.
      LOOP AT io_user->friends( ) INTO DATA(lo_friend).
        IF lo_friend = lo_logged_user.
          lv_is_friend = abap_true.
          EXIT.
        ENDIF.
      ENDLOOP.
      IF lv_is_friend = abap_true.
        lt_trip_list = lcl_trip_dao=>find_trips_by_user( io_user ).
      ENDIF.
      rt_trips = lt_trip_list.
    ELSE.
      RAISE EXCEPTION TYPE lcx_user_not_logged_in.
    ENDIF.
  ENDMETHOD.

ENDCLASS.


*& Test Code
CLASS ltc_trip_service_test DEFINITION FINAL RISK LEVEL HARMLESS FOR TESTING.

ENDCLASS.

CLASS ltc_trip_dao_test DEFINITION FINAL RISK LEVEL HARMLESS FOR TESTING.

ENDCLASS.

CLASS ltc_user_test DEFINITION FINAL RISK LEVEL HARMLESS FOR TESTING.

ENDCLASS.
