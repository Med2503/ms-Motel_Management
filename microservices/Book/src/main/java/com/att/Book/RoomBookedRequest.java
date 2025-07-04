package com.att.Book;

import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record RoomBookedRequest(
        @NotNull(message = "id is required!")
        Integer roomId,
        @NotNull(message = "number  of beds is required!")
        double beds
) {
}
