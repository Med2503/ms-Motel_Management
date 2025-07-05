package com.att.Book_Transaction;

public record BookTransactionRequest(
        Integer id,
        Integer bookingId,
        Integer roomId,
        double beds

) {
}
