package com.att.Guest;


import org.springframework.stereotype.Component;

@Component
public class GuestMapper {


    public Guest toGuest(GuestRequest request) {
        if (request == null) {
            return null;
        }
        return new Guest(request.id(), request.firstname(), request.lastname(), request.email(), request.location());

    }

    public GuestResponse fromGuest(Guest guest) {
        if (guest == null) {
            return null;
        }
        return new GuestResponse(
                guest.getId(),
                guest.getFirstname(),
                guest.getLastname(),
                guest.getEmail(),
                guest.getLocation()
        );
    }
}
