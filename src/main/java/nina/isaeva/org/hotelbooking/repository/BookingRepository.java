package nina.isaeva.org.hotelbooking.repository;

import nina.isaeva.org.hotelbooking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("select b from Booking b where b.checkInDate = CURRENT_DATE order by b.guestName asc ")
    Set<Booking> findAllCheckInDates();


    @Query("select b from Booking b where b.checkOutDate = CURRENT_DATE order by b.guestName asc ")
    Set<Booking> findAllCheckOutDates();

    Booking findBookingByGuestName(String guestName);





}
