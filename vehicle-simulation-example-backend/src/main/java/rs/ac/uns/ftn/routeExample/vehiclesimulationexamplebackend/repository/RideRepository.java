package rs.ac.uns.ftn.routeExample.vehiclesimulationexamplebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.uns.ftn.routeExample.vehiclesimulationexamplebackend.domain.Ride;
import rs.ac.uns.ftn.routeExample.vehiclesimulationexamplebackend.domain.RideStatus;

import java.util.List;
import java.util.Optional;

@Repository
public interface RideRepository extends JpaRepository<Ride, Integer> {

    Optional<Ride> findById(int id);

    List<Ride> findAllByRideStatus(RideStatus rideStatus);
}
