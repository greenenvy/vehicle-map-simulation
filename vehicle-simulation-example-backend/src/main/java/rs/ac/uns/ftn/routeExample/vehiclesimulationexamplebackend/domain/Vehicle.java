package rs.ac.uns.ftn.routeExample.vehiclesimulationexamplebackend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.ac.uns.ftn.routeExample.vehiclesimulationexamplebackend.dto.VehicleDTO;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "licensePlateNumber", nullable = false)
    private String licensePlateNumber;

    @Embedded
    private Location currentLocation;

    public Vehicle(VehicleDTO vehicleDTO) {
        this.id = vehicleDTO.getId();
        this.licensePlateNumber = vehicleDTO.getLicensePlateNumber();
        this.currentLocation = new Location(vehicleDTO.getLatitude(), vehicleDTO.getLongitude());
    }
}
