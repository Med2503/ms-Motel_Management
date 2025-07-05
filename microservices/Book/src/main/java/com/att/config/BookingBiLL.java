package com.att.config;

import com.att.Book.BillingMethod;
import com.att.Book.GuestResponse;
import com.att.Book.RoomBookedResponse;

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
