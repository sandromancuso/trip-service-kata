<?php

namespace Test\TripServiceKata\Trip;

use PHPUnit\Framework\TestCase;
use TripServiceKata\Trip\TripService;

class TripServiceShould extends TestCase
{
    /**
     * @var TripService
     */
    private TripService $tripService;

    protected function setUp(): void
    {
        $this->tripService = new TripService();
    }

    /** @test */
    public function do_something()
    {
        $this->fail('This test has not been implemented yet.');
    }
}
