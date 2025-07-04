package com.att.Book;

import org.springframework.stereotype.Service;

@Service
public class BookingMapper {


    public Booking toBooking(BookRequest request) {
        if (request == null) {
            return null;
        }

        return Booking.builder()
                .id(request.id())
                .reference(request.reference())
                .amount(request.amount())
                .billingMethod(request.method())
                .build();
    }

    public BookResponse toBookResponse(Booking booking) {

        return new BookResponse(
                booking.getId(),
                booking.getReference(),
                booking.getAmount(),
                booking.getBillingMethod(),
                booking.getGuestId()
        );

    }
}
