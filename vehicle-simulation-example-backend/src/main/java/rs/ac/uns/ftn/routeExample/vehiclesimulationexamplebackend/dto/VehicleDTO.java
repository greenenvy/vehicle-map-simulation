package rs.ac.uns.ftn.routeExample.vehiclesimulationexamplebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.ac.uns.ftn.routeExample.vehiclesimulationexamplebackend.domain.Vehicle;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {
    private int id;
    private String licensePlateNumber;
    private double latitude;
    private double longitude;

    public VehicleDTO(Vehicle vehicle) {
        this.id = vehicle.getId();
        this.licensePlateNumber = vehicle.getLicensePlateNumber();
        this.latitude = vehicle.getCurrentLocation().getLatitude();
        this.longitude = vehicle.getCurrentLocation().getLongitude();
    }
}
