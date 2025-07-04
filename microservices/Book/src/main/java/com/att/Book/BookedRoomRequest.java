package com.att.Book;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;

@Validated
public record BookedRoomRequest(
        @NotNull(message = "roomId is required!")
        Integer roomId,
        @Positive(message = "beds is required!")
        double beds
) {
}
