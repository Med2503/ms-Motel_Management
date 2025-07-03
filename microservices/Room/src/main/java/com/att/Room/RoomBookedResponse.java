package com.att.Room;

import java.math.BigDecimal;

public record RoomBookedResponse(
        Integer roomId,
        String description,

        BigDecimal price,
        double places
) {
}
