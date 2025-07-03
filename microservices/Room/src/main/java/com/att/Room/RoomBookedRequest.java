package com.att.Room;

import jakarta.validation.constraints.NotNull;

public record RoomBookedRequest(
        @NotNull(message = "id is required!")
        Integer roomId,
        @NotNull(message = "number  of places is required!")
        double places
) {
}
