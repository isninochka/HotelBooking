package nina.isaeva.org.hotelbooking.entity.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RoomCategory {
    PRESIDENT("president"),
    LUXURY("luxury"),
    DELUXE("deluxe"),
    STANDARD("standard"),
    SINGLE("single");

    private final String value;

    RoomCategory(String value) {
        this.value = value;
    }
    @JsonValue
    public String getValue() {
        return value;
    }
}
