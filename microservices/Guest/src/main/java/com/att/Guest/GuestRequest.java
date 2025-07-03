package com.att.Guest;

import jakarta.validation.constraints.NotNull;

public record GuestRequest(
        String id,
        @NotNull(message = "firstname is mandatory")
        String firstname,
        @NotNull(message = "lastname is mandatory")
        String lastname,
        @NotNull(message = "email is mandatory")
        String email,
        Location location


) {
}
