package nina.isaeva.org.hotelbooking.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nina.isaeva.org.hotelbooking.entity.enums.RoomCategory;


import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;



@Data
@Entity
@Table(name = "rooms")
@NoArgsConstructor

public class Room {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "room_number", nullable = false)
    private int roomNumber;

    @Enumerated(EnumType.ORDINAL)
    private RoomCategory roomCategory;

    double price;

    @Column(name = "is_booked")
    private boolean isBooked = false;


    public Room (int roomNumber,RoomCategory roomCategory, double price, boolean isBooked) {
        this.roomNumber = roomNumber;
        this.roomCategory = roomCategory;
        this.price = price;
        this.isBooked = isBooked;
    }


    @OneToMany(mappedBy = "room",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    private Set<Booking> bookings = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Hotel hotel;


    @OneToMany(mappedBy = "room",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Review> reviews = new HashSet<>();

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public void addBooking(Booking booking) {
        this.bookings.add(booking);
    }
    public void removeBooking(Booking booking) {
        this.bookings.remove(booking);
    }
    public void removeReview(Review review) {
        this.reviews.remove(review);
    }






}
