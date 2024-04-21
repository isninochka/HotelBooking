package nina.isaeva.org.hotelbooking.mapper;

import nina.isaeva.org.hotelbooking.dto.HotelDto;
import nina.isaeva.org.hotelbooking.entity.Hotel;
import org.springframework.stereotype.Component;



@Component
public class HotelMapper {

    public HotelDto toHotelDto(Hotel hotel) {
        return new HotelDto(hotel.getHotelName(),
                hotel.getHotelAddress(), hotel.getHotelCategory().getStars());
    }


}
