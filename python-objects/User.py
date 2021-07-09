class User(object):
    def __init__(self):
        self._trips = []
        self._friends = []

    def get_friends(self):
        return self._friends

    def add_friend(self, user):
        self._friends.append(user)

    def add_trip(self, trip):
        self._trips.append(trip)

    def trips(self):
        return self._trips
