class ZCL_PAO_USER definition
  public
  final
  create public .

public section.

  types:
    tt_user TYPE STANDARD TABLE OF REF TO zcl_pao_user WITH EMPTY KEY .

  methods ADD_FRIEND
    importing
      !IV_USER type ref to ZCL_PAO_USER .
  methods ADD_TRIP
    importing
      !IV_TRIP type ref to ZCL_PAO_TRIP .
  methods GET_FRIENDS
    returning
      value(RT_USERS) type TT_USER .
  methods TRIPS
    returning
      value(RT_TRIPS) type ZCL_PAO_TRIP=>TT_TRIP .
  PRIVATE SECTION.
    DATA:
      mt_trips   TYPE zcl_pao_trip=>tt_trip,
      mt_friends TYPE tt_user.
ENDCLASS.



CLASS ZCL_PAO_USER IMPLEMENTATION.


  METHOD add_friend.
    APPEND iv_user TO mt_friends.
  ENDMETHOD.


  METHOD add_trip.
    APPEND iv_trip TO mt_trips.
  ENDMETHOD.


  METHOD get_friends.
    rt_users = mt_friends.
  ENDMETHOD.


  METHOD trips.
    rt_trips = mt_trips.
  ENDMETHOD.
ENDCLASS.
