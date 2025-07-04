package com.att.Booking;

public record BookTransactionRequest(
        Integer id,
        Integer bookingId,
        Integer roomId,
        double beds

) {
}
