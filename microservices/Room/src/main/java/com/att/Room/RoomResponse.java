package com.att.Room;

import java.math.BigDecimal;

public record RoomResponse(
        Integer id,
        String description,
        double availablePlaces,
        BigDecimal price,

        Integer RoomTypeId,
        String RoomType,
        String RoomTypeDescription

) {
}
