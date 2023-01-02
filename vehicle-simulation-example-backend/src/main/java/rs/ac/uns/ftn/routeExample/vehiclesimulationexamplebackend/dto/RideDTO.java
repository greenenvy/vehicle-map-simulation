package rs.ac.uns.ftn.routeExample.vehiclesimulationexamplebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.ac.uns.ftn.routeExample.vehiclesimulationexamplebackend.domain.Ride;
import rs.ac.uns.ftn.routeExample.vehiclesimulationexamplebackend.domain.RideStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideDTO {
    private int id;
    private String routeJSON;
    private RideStatus rideStatus;
    private VehicleDTO vehicle;

    public RideDTO(Ride ride) {
        this.id = ride.getId();
        this.routeJSON = ride.getRouteJSON();
        this.rideStatus = ride.getRideStatus();
        this.vehicle = new VehicleDTO(ride.getVehicle());
    }
}
