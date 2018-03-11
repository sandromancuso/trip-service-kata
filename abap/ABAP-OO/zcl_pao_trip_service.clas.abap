class ZCL_PAO_TRIP_SERVICE definition
  public
  final
  create public .

public section.

  methods GET_TRIPS_BY_USER
    importing
      !IO_USER type ref to ZCL_PAO_USER
    returning
      value(RT_TRIPS) type ZCL_PAO_TRIP=>TT_TRIP
    raising
      ZCX_PAO_USER_NOT_LOGGED_IN .
ENDCLASS.



CLASS ZCL_PAO_TRIP_SERVICE IMPLEMENTATION.


  METHOD get_trips_by_user.
    DATA(lt_trip_list) = VALUE zcl_pao_trip=>tt_trip( ).
    DATA(lo_logged_user) = zcl_pao_user_session=>get_instance( )->get_logged_user( ).
    DATA(lv_is_friend) = abap_false.
    IF lo_logged_user IS BOUND.
      LOOP AT io_user->get_friends( ) INTO DATA(lo_friend).
        IF lo_friend = lo_logged_user.
          lv_is_friend = abap_true.
          EXIT.
        ENDIF.
      ENDLOOP.
      IF lv_is_friend = abap_true.
        lt_trip_list = zcl_pao_trip_dao=>find_trips_by_user( io_user ).
      ENDIF.
      rt_trips = lt_trip_list.
    ELSE.
      RAISE EXCEPTION TYPE zcx_pao_user_not_logged_in.
    ENDIF.
  ENDMETHOD.
ENDCLASS.
