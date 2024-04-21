package nina.isaeva.org.hotelbooking.mapper;

import nina.isaeva.org.hotelbooking.dto.BookingRequestDto;
import nina.isaeva.org.hotelbooking.dto.BookingResponseDto;
import nina.isaeva.org.hotelbooking.entity.Booking;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class BookingMapper {

      public BookingResponseDto toBookingResponseDto(Booking booking) {

        return new BookingResponseDto(
                booking.getGuestName(),
                booking.getCheckInDate(),
                booking.getCheckOutDate(),
                booking.getHotel().getHotelName(),
                booking.getRoom().getRoomNumber(),
                booking.getTotalPrice());



    }

    public Set<BookingResponseDto> toBookingResponseDtoSet(Set<Booking> bookings) {
        return bookings.stream()
                .map(this::toBookingResponseDto)
                .collect(Collectors.toSet());

    }

    public Booking toBooking(BookingRequestDto bookingRequestDto) {
        return Booking.builder()
                .guestName(bookingRequestDto.getGuestName())
                .checkInDate(bookingRequestDto.getCheckInDate())
                .checkOutDate(bookingRequestDto.getCheckOutDate())
                .build();

    }
}
