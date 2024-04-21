package nina.isaeva.org.hotelbooking.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nina.isaeva.org.hotelbooking.entity.enums.HotelCategory;
import nina.isaeva.org.hotelbooking.entity.enums.RoomCategory;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponseDto {
    private String guestName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate checkInDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate checkOutDate;
    private String hotelName;
    private int roomNumber;
    private double totalPrice;


        public BookingResponseDto(String hotelName, HotelCategory hotelCategory, int roomNumber, RoomCategory roomCategory, LocalDate checkIn, LocalDate checkOut, double totalPrice) {
        }


}
