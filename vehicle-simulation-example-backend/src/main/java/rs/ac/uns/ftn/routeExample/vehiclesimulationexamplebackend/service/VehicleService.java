package rs.ac.uns.ftn.routeExample.vehiclesimulationexamplebackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.routeExample.vehiclesimulationexamplebackend.domain.Location;
import rs.ac.uns.ftn.routeExample.vehiclesimulationexamplebackend.domain.Vehicle;
import rs.ac.uns.ftn.routeExample.vehiclesimulationexamplebackend.exception.BadRequestException;
import rs.ac.uns.ftn.routeExample.vehiclesimulationexamplebackend.exception.NotFoundException;
import rs.ac.uns.ftn.routeExample.vehiclesimulationexamplebackend.repository.VehicleRepository;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle createVehicle(Vehicle vehicle) {
        if (this.vehicleRepository.existsByLicensePlateNumber(vehicle.getLicensePlateNumber())) {
            throw new BadRequestException("Vehicle already exists!");
        }
        return this.vehicleRepository.save(vehicle);
    }

    public Vehicle updateVehicleLocation(int id, double latitude, double longitude) {
        Vehicle vehicle = this.vehicleRepository.findById(id).orElseThrow(() -> new NotFoundException("Vehicle does not exist!"));
        vehicle.setCurrentLocation(new Location(latitude, longitude));
        return this.vehicleRepository.save(vehicle);
    }

    public void deleteAllVehicles() {
        this.vehicleRepository.deleteAll();
    }
}
