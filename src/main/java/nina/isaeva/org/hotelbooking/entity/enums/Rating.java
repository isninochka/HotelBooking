package nina.isaeva.org.hotelbooking.entity.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum Rating {

    ONE_STAR(1),
    TWO_STARS(2),
    TREE_STARS(3),
    FOUR_STARS(4),
    FIVE_STARS(5);

    private final int stars;

    Rating(int stars) {
        this.stars = stars;
    }
    @JsonValue
    public int getStars() {
        return stars;
    }
}
