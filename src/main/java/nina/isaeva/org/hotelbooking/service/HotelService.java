package nina.isaeva.org.hotelbooking.service;

import lombok.RequiredArgsConstructor;
import nina.isaeva.org.hotelbooking.dto.BookingRequestDto;
import nina.isaeva.org.hotelbooking.dto.HotelDto;
import nina.isaeva.org.hotelbooking.entity.Hotel;
import nina.isaeva.org.hotelbooking.entity.Room;
import nina.isaeva.org.hotelbooking.entity.enums.RoomCategory;
import nina.isaeva.org.hotelbooking.exception.HotelNotFoundException;
import nina.isaeva.org.hotelbooking.mapper.HotelMapper;
import nina.isaeva.org.hotelbooking.repository.HotelRepository;
import nina.isaeva.org.hotelbooking.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;
    private final HotelMapper hotelMapper;



    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }


    public HotelDto getHotelById(Long id) {
        return hotelMapper.toHotelDto(hotelRepository.getReferenceById(id));
    }

    public Hotel findByHotelName(BookingRequestDto dto){
        List<Hotel> hotels = getAllHotels();
        Hotel findingHotel = null;
        for (Hotel hotel : hotels) {
            if (hotel.getHotelName().equals(dto.getHotelName())){
                findingHotel = hotel;
                return findingHotel;
            } else {
                throw new HotelNotFoundException(dto.getHotelName());
            }

        }
        return findingHotel;

    }

    public Hotel createHotelWithRooms(HotelDto dto){

        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(555,RoomCategory.PRESIDENT, 5000,false));
        for (int i = 0; i < 3; i++) {
            int numeration = 400+i;
            rooms.add(new Room(numeration,RoomCategory.LUXURY, 2000,false));
        }
        for (int i = 0; i < 5; i++) {
            int numeration = 300+i;
            rooms.add(new Room(numeration,RoomCategory.DELUXE, 1500,false));
        }
        for (int i = 0; i < 20; i++) {
            int numeration = 200+i;
            rooms.add(new Room(numeration,RoomCategory.STANDARD, 200,false));
        }
        for (int i = 0; i < 10; i++) {
            int numeration = 100+i;
            rooms.add(new Room(numeration,RoomCategory.SINGLE, 180,false));
        }

        List<Room> roomsList = roomRepository.saveAll(rooms);
        return new Hotel(dto.getHotelName(),
                dto.getHotelAddress(),
                roomsList);

    }

    public void deleteHotelById(Long id) {
        Hotel hotel = hotelRepository.findById(id).get();
        hotelRepository.delete(hotel);
    }



}
