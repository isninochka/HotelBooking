package nina.isaeva.org.hotelbooking.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nina.isaeva.org.hotelbooking.dto.BookingRequestDto;
import nina.isaeva.org.hotelbooking.dto.BookingResponseDto;
import nina.isaeva.org.hotelbooking.service.BookingService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
@Validated
public class BookingController {

    private final BookingService bookingService;

    @GetMapping
    public Set<BookingResponseDto> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @PostMapping
    public BookingResponseDto addBooking(@Validated @RequestBody BookingRequestDto requestDto) {
        return bookingService.addBooking(requestDto);
    }

    @GetMapping("/{id}")
    public BookingResponseDto findBookingById(@PathVariable Long id) {
        return bookingService.findBookingById(id);
    }

    @GetMapping("/findByName")
    public BookingResponseDto findBookingByGuestName(@RequestParam String guestName) {
        return bookingService.findBookingByGuestName(guestName);
    }

    @DeleteMapping
    public void deleteBookingById(@RequestParam Long id) {
        bookingService.deleteBooking(id);
    }
}
