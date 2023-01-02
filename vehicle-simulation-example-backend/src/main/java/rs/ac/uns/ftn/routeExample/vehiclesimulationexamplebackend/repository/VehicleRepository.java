package rs.ac.uns.ftn.routeExample.vehiclesimulationexamplebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.uns.ftn.routeExample.vehiclesimulationexamplebackend.domain.Vehicle;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    Optional<Vehicle> findVehicleByLicensePlateNumber(String licencePlateNumber);

    boolean existsByLicensePlateNumber(String licensePLateNUmber);
}
