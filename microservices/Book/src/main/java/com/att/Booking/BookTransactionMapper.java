package com.att.Booking;


import com.att.Book.Booking;
import org.springframework.stereotype.Service;

@Service
public class BookTransactionMapper {

    public BookTransaction toBookTransaction(BookTransactionRequest request) {
        return BookTransaction.builder()
                .id(request.id())
                .roomId(request.roomId())
                .booking(
                        Booking.builder()
                                .id(request.bookingId())
                                .build()
                )
                .beds(request.beds())
                .build();
    }

    public BookTransactionResponse toBookTransactionResponse(BookTransaction bookTransaction) {
        return new BookTransactionResponse(
                bookTransaction.getId(),
                bookTransaction.getBeds()
        );
    }

}
