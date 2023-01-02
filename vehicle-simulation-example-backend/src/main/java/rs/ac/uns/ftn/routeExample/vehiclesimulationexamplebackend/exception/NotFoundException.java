package rs.ac.uns.ftn.routeExample.vehiclesimulationexamplebackend.exception;

@SuppressWarnings("serial")
public class NotFoundException extends RuntimeException {

    public NotFoundException() {}

    public NotFoundException(String message) {
        super(message);
    }
}

