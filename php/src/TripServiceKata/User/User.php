<?php

namespace TripServiceKata\User;

use TripServiceKata\Trip\Trip;

class User
{
    /** @var Trip[] */
    private array $trips;

    /** @var User[] */
    private array $friends;
    private readonly string $name;

    public function __construct(string $name)
    {
        $this->name = $name;
        $this->trips = array();
        $this->friends = array();
    }

    public function getTrips(): array
    {
        return $this->trips;
    }

    public function getFriends(): array
    {
        return $this->friends;
    }

    public function addFriend(User $user): void
    {
        $this->friends[] = $user;
    }

    public function addTrip(Trip $trip): void
    {
        $this->trips[] = $trip;
    }
}
