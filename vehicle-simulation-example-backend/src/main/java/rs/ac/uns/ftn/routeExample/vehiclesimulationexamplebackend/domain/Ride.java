package rs.ac.uns.ftn.routeExample.vehiclesimulationexamplebackend.domain;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import rs.ac.uns.ftn.routeExample.vehiclesimulationexamplebackend.dto.RideDTO;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@TypeDef(name = "json", typeClass = JsonType.class)
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private String routeJSON;

    @Enumerated(EnumType.STRING)
    @Column()
    private RideStatus rideStatus;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Vehicle Vehicle;

    public Ride(RideDTO rideDTO) {
        this.id = rideDTO.getId();
        this.routeJSON = rideDTO.getRouteJSON();
        this.rideStatus = rideDTO.getRideStatus();
    }
}
