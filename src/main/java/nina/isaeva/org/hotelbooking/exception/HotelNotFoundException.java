package nina.isaeva.org.hotelbooking.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class HotelNotFoundException extends RuntimeException {

    public HotelNotFoundException() {}
    public HotelNotFoundException(String message) {
        super(message);
    }
}
