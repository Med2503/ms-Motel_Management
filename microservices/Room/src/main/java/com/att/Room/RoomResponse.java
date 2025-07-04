package com.att.Room;

import java.math.BigDecimal;

public record RoomResponse(
        Integer id,
        String description,
        double availableBeds,
        BigDecimal price,

        Integer RoomTypeId,
        String RoomType,
        String RoomTypeDescription

) {
}
