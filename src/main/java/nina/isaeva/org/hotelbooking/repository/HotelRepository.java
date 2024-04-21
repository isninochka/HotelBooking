package nina.isaeva.org.hotelbooking.repository;

import nina.isaeva.org.hotelbooking.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    Hotel findByHotelName(String hotelName);
}
