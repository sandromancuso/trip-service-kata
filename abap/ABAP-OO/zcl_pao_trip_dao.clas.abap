class ZCL_PAO_TRIP_DAO definition
  public
  final
  create public .

public section.

  class-methods FIND_TRIPS_BY_USER
    importing
      !IO_USER type ref to ZCL_PAO_USER
    returning
      value(RT_TRIPS) type ZCL_PAO_TRIP=>TT_TRIP .
ENDCLASS.



CLASS ZCL_PAO_TRIP_DAO IMPLEMENTATION.


  METHOD find_trips_by_user.
    RAISE EXCEPTION TYPE zcx_pao_collaborator_call
      EXPORTING
        iv_text = |zcl_pao_trip_dao should not be invoked during unit test|.
  ENDMETHOD.
ENDCLASS.
