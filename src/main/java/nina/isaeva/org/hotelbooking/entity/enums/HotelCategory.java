package nina.isaeva.org.hotelbooking.entity.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum HotelCategory {
    ONE_STAR(1),
    TWO_STARS(2),
    TREE_STARS(3),
    FOUR_STARS(4),
    FIVE_STARS(5);

    private final int stars;

    HotelCategory(int stars) {
        this.stars = stars;
    }

    @JsonValue
    public static HotelCategory getStars(int stars) {
        for (HotelCategory star : HotelCategory.values()) {
            if (star.getStars() == stars) {
                return star;
            }
        }
        return null;
    }


}
