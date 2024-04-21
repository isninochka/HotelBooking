package nina.isaeva.org.hotelbooking.exception;

public class RoomAlreadyBookedException extends RuntimeException{

    private String message;
    public RoomAlreadyBookedException() {}
    public RoomAlreadyBookedException(String message) {
        this.message = message;
    }
}
