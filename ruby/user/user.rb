class User
    def initialize
        @trips = []
        @friends = []
    end

    def get_friends
        @friends
    end

    def add_friend(user)
        @friends << user
    end

    def add_trip(trip)
        @trips << trip
    end

    def trips
        @trips
    end
end
