package rs.ac.uns.ftn.routeExample.vehiclesimulationexamplebackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.routeExample.vehiclesimulationexamplebackend.domain.Ride;
import rs.ac.uns.ftn.routeExample.vehiclesimulationexamplebackend.domain.RideStatus;
import rs.ac.uns.ftn.routeExample.vehiclesimulationexamplebackend.domain.Vehicle;
import rs.ac.uns.ftn.routeExample.vehiclesimulationexamplebackend.exception.NotFoundException;
import rs.ac.uns.ftn.routeExample.vehiclesimulationexamplebackend.repository.RideRepository;
import rs.ac.uns.ftn.routeExample.vehiclesimulationexamplebackend.repository.VehicleRepository;

import java.util.List;

@Service
public class RideService {

    private final RideRepository rideRepository;
    private final VehicleRepository vehicleRepository;

    @Autowired
    public RideService(RideRepository rideRepository, VehicleRepository vehicleRepository) {
        this.rideRepository = rideRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public Ride createRide(Ride ride, Vehicle vehicle) {
        Ride returnRide = this.rideRepository.save(ride);
        Vehicle storedVehicle = this.vehicleRepository.findById(vehicle.getId()).orElseThrow(
                () -> new NotFoundException("Vehicle does not exist"));
        returnRide.setVehicle(storedVehicle);
        return this.rideRepository.save(returnRide);
    }

    public Ride changeRide(int id) {
        Ride ride = this.rideRepository.findById(id).orElseThrow(() -> new NotFoundException("Ride does not exist!"));
        ride.setRideStatus(RideStatus.ENDED);
        return this.rideRepository.save(ride);
    }

    public List<Ride> getRides() {
        return this.rideRepository.findAllByRideStatus(RideStatus.STARTED);
    }

    public void deleteAllRides() {
        this.rideRepository.deleteAll();
    }
}
