package nina.isaeva.org.hotelbooking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nina.isaeva.org.hotelbooking.entity.enums.HotelCategory;
import nina.isaeva.org.hotelbooking.entity.enums.RoomCategory;


import java.time.LocalDate;
@Builder
@Data
@Entity
@Table(name = "bookings")
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "guest_name", nullable = false)
    private String guestName;
    @Column(name = "check_in_date", nullable = false)
    private LocalDate checkInDate;
    @Column(name = "check_out_date", nullable = false)
    private LocalDate checkOutDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;
    @Enumerated(EnumType.ORDINAL)
    private RoomCategory roomCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    private Hotel hotel;
    @Enumerated(EnumType.ORDINAL)
    private HotelCategory hotelCategory;
    @Column(name = "total_price")
    double totalPrice;

    public Booking(Hotel hotel, Room room, LocalDate checkIn, LocalDate checkOut, double totalPrice) {
        this.hotel = hotel;
        this.room = room;
        this.checkInDate = checkIn;
        this.checkOutDate = checkOut;

    }

}
