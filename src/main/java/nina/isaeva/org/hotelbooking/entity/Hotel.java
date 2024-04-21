package nina.isaeva.org.hotelbooking.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nina.isaeva.org.hotelbooking.entity.enums.HotelCategory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@Entity
@Table(name = "hotels")
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hotel_name", nullable = false)
    private String hotelName;

    @Column(name = "hotel_adress", nullable = false)
    private String hotelAddress;

    @Enumerated(EnumType.ORDINAL)
    private HotelCategory hotelCategory;


    @OneToMany(mappedBy = "hotel",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    private List<Room> rooms;

    public Hotel(String hotelName, String hotelAddress, List<Room> rooms) {
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.rooms = rooms;
    }


    @OneToMany(mappedBy = "hotel",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Booking> bookings = new HashSet<>();


    @OneToMany(mappedBy = "hotel",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    private Set<Review> reviews = new HashSet<>();


    public Hotel(String name, String address, HotelCategory category) {
        this.hotelName = name;
        this.hotelAddress = address;
        this.hotelCategory = category;

    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
        booking.setHotel(this);
    }
    public void addReview(Review review) {
        reviews.add(review);
        review.setHotel(this);
    }
    public void addHotelCategory(HotelCategory hotelCategory) {
        this.hotelCategory = hotelCategory;
    }

    public List<Room>getAllRooms (){
        return rooms;
    }


}
