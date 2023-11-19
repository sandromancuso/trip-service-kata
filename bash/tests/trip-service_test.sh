#!/bin/bash

function set_up_before_script() {
  source "$(dirname "${BASH_SOURCE[0]}")/../src/trip-service.sh"
}

function test_get_trip_by_user() {
  todo "test the logic from get_trip_by_user"
}
