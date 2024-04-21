package nina.isaeva.org.hotelbooking.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nina.isaeva.org.hotelbooking.dto.BookingRequestDto;
import nina.isaeva.org.hotelbooking.dto.BookingResponseDto;
import nina.isaeva.org.hotelbooking.entity.Booking;
import nina.isaeva.org.hotelbooking.entity.Hotel;
import nina.isaeva.org.hotelbooking.entity.Room;
import nina.isaeva.org.hotelbooking.exception.HotelNotFoundException;
import nina.isaeva.org.hotelbooking.exception.NoSuchBookingExistException;
import nina.isaeva.org.hotelbooking.exception.RoomAlreadyBookedException;
import nina.isaeva.org.hotelbooking.mapper.BookingMapper;
import nina.isaeva.org.hotelbooking.repository.BookingRepository;
import nina.isaeva.org.hotelbooking.repository.HotelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final HotelRepository hotelRepository;




    public Set<BookingResponseDto> getAllBookings() {
        return bookingMapper.toBookingResponseDtoSet(new HashSet<>(bookingRepository.findAll()));
    }


    public BookingResponseDto findBookingById(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(NoSuchBookingExistException::new);
        return bookingMapper.toBookingResponseDto(booking);
    }

    public BookingResponseDto findBookingByGuestName(String guestName) {
        Booking booking = bookingRepository.findBookingByGuestName(guestName);
        return bookingMapper.toBookingResponseDto(booking);
    }

    @Transactional
    public BookingResponseDto addBooking(BookingRequestDto bookingRequestDto) {
        Hotel hotel = hotelRepository.findByHotelName(bookingRequestDto.getHotelName());
        if (hotel == null) {
            throw new HotelNotFoundException();
        }
        Room room = hotel.getRooms().stream()
                .filter(r->r.getRoomCategory().equals(bookingRequestDto.getRoomCategory()) && !r.isBooked())
                .findFirst()
                .orElseThrow(RoomAlreadyBookedException::new);

        LocalDate checkIn = bookingRequestDto.getCheckInDate();
        LocalDate checkOut = bookingRequestDto.getCheckOutDate() ;
        if(!isRoomAvailable(room, checkIn, checkOut)) {
            double totalPrice = calculatePrice(room,checkIn,checkOut);
            room.setBooked(true);
            Booking booking = bookingMapper.toBooking(bookingRequestDto);
            return bookingMapper.toBookingResponseDto(booking);

        } else {
            return null;
        }


    }

    private boolean isRoomAvailable(Room room, LocalDate checkIn, LocalDate checkOut) {
        return room.isBooked() ||
                room.getBookings().stream()
                        .noneMatch(booking -> checkIn.isBefore(booking.getCheckOutDate())
                                && checkOut.isAfter(booking.getCheckInDate()));
    }

    private double calculatePrice(Room room, LocalDate checkIn, LocalDate checkOut) {
        int days = checkIn.getDayOfMonth() - checkOut.getDayOfMonth();
        double price = room.getPrice();
       return days * price;

    }

    @Transactional
    public void deleteBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).get();
        bookingRepository.delete(booking);
    }



}
