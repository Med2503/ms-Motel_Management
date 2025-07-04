package com.att.Room;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record RoomRequest(
        Integer id,
        @NotNull(message = "room description is mandatory")
        String description,
        @Positive(message = "availableBeds should be positive")
        double availableBeds,
        @Positive(message = "price should be positive")
        BigDecimal price,
        @NotNull(message = "RoomTypeId is mandatory")
        Integer RoomTypeId


) {
}
