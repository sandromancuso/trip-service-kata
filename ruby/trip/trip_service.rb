require_relative '../trip/trip_dao'
require_relative '../user/user_session'
require_relative '../user/user'
require_relative '../еxceptions/user_not_logged_in_exception'
require_relative '../еxceptions/dependend_class_call_during_unit_test_exception'

class TripService

    def get_trip_by_user(user)
        trip_list = []
        logged_user = UserSession.get_instance.get_logged_user
        is_friend = false

        if(!logged_user.nil?)
            user.get_friends.each do |f|
                if(f.equal? logged_user)
                    is_friend = true
                    break
                end
            end

            if(is_friend)
                trip_list = TripDAO.find_trips_by_user(user)
            end

            return trip_list
        else
            raise UserNotLoggedInException.new
        end

    end

end