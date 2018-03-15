CLASS zcx_pao_collaborator_call DEFINITION
  PUBLIC
  INHERITING FROM cx_dynamic_check
  FINAL
  CREATE PUBLIC .

  PUBLIC SECTION.

    METHODS constructor
      IMPORTING
        !iv_text TYPE string .

    METHODS if_message~get_text
         REDEFINITION .
  PRIVATE SECTION.
    DATA mv_text TYPE string.
ENDCLASS.



CLASS zcx_pao_collaborator_call IMPLEMENTATION.


  METHOD constructor.
    super->constructor( ).
    mv_text = iv_text.
  ENDMETHOD.


  METHOD if_message~get_text.
    result = mv_text.
  ENDMETHOD.

ENDCLASS.
