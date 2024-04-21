package nina.isaeva.org.hotelbooking.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nina.isaeva.org.hotelbooking.entity.enums.RoomCategory;
import nina.isaeva.org.hotelbooking.entity.enums.HotelCategory;

import java.time.LocalDate;
import java.util.Objects;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequestDto {
    private @NotNull String guestName;
    private @NotNull String hotelName;
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "dd.MM.yyyy")
    private @Future
    @NotNull LocalDate checkInDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "dd.MM.yyyy")
    private @Future
    @NotNull LocalDate checkOutDate;
    @JsonProperty("roomCategory")
    private @NotNull RoomCategory roomCategory;




}
