package com.example.Invoice;

import java.math.BigDecimal;

public record RoomBookedResponse(
        Integer roomId,
        String description,

        BigDecimal price,
        double beds
) {
}
