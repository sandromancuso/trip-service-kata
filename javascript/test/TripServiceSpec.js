import assert from 'assert';
import TripService from '../src/TripService';

describe('TripService', () => {

    it('should return no trips if users are not friends', () => {
        const tripService = new TripService();
        assert.equal(tripService.getTripsByUser('not a friend'), []);
    });

});
