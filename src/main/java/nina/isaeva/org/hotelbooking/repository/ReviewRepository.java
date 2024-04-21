package nina.isaeva.org.hotelbooking.repository;

import nina.isaeva.org.hotelbooking.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
