mod users;
mod trip_service;

fn main() {
    let service: trip_service::TripService = trip_service::TripService{};

    service.build_check();
}
