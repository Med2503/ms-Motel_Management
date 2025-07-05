package com.att.Book;

import java.math.BigDecimal;
import java.util.List;

public record BookingBiLL(
        String bookingRef,
        BigDecimal amount,

        BillingMethod method,

        GuestResponse guest,
        List<RoomBookedResponse> list


) {


}
