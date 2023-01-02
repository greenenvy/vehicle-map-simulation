package rs.ac.uns.ftn.routeExample.vehiclesimulationexamplebackend.exception;

@SuppressWarnings("serial")
public class BadRequestException extends RuntimeException {

    public BadRequestException() {}

    public BadRequestException(String message) {
        super(message);
    }
}

