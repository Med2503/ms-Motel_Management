package com.att.Guest;

public record GuestResponse(

        String id,
        String firstname,
        String lastname,
        String email,

        Location location
) {
}
