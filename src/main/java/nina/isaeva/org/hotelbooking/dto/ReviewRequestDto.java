package nina.isaeva.org.hotelbooking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import nina.isaeva.org.hotelbooking.entity.Hotel;
import nina.isaeva.org.hotelbooking.entity.Room;
import nina.isaeva.org.hotelbooking.entity.enums.Rating;

public record ReviewRequestDto(

        @NotNull @JsonProperty("rating")
        Rating rating,
        @NotNull
        Hotel hotel,
        @NotNull
        Room room,
        @NotNull
        String message) {
}
