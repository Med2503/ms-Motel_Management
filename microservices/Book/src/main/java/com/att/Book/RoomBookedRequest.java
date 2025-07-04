package com.att.Book;

import jakarta.validation.constraints.NotNull;

public record RoomBookedRequest(
        @NotNull(message = "id is required!")
        Integer roomId,
        @NotNull(message = "number  of beds is required!")
        double beds
) {
}
