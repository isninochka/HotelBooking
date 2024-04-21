package nina.isaeva.org.hotelbooking.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class NoSuchBookingExistException extends RuntimeException {

    public NoSuchBookingExistException() {}

    public NoSuchBookingExistException(String message) {
        super(message);
    }
}
