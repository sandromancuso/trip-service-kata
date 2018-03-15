class ZCL_PAO_USER_SESSION definition
  public
  final
  create private .

public section.

  class-methods CLASS_CONSTRUCTOR .
  class-methods GET_INSTANCE
    returning
      value(RO_VALUE) type ref to ZCL_PAO_USER_SESSION .
  methods GET_LOGGED_USER
    returning
      value(RO_VALUE) type ref to ZCL_PAO_USER .
  PRIVATE SECTION.
    CLASS-DATA:
      go_user_session TYPE REF TO zcl_pao_user_session.
ENDCLASS.



CLASS ZCL_PAO_USER_SESSION IMPLEMENTATION.


  METHOD class_constructor.
    go_user_session = NEW #( ).
  ENDMETHOD.


  METHOD get_instance.
    ro_value = go_user_session.
  ENDMETHOD.


  METHOD get_logged_user.
    RAISE EXCEPTION TYPE zcx_pao_collaborator_call
      EXPORTING
        iv_text = |zcl_pao_user_session->logged_user() should not be called during unit test|.
  ENDMETHOD.
ENDCLASS.
