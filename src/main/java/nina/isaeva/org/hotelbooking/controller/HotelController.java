package nina.isaeva.org.hotelbooking.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nina.isaeva.org.hotelbooking.dto.HotelDto;
import nina.isaeva.org.hotelbooking.entity.Hotel;
import nina.isaeva.org.hotelbooking.mapper.HotelMapper;
import nina.isaeva.org.hotelbooking.service.HotelService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/hotels")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;


    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @PostMapping
    public Hotel createHotelWithAllNumbers(@RequestBody HotelDto dto){
       return hotelService.createHotelWithRooms(dto);
    }

    @DeleteMapping
    public void deleteHotel(@RequestParam Long hotelId) {
        hotelService.deleteHotelById(hotelId);

    }
}
