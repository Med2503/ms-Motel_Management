package com.att.Booking;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/booking-transaction")
public class BookTransactionController {

    private final BookTransactionService service;

    public BookTransactionController(BookTransactionService service) {
        this.service = service;
    }

    @GetMapping("/booking/{book-id}")
    public ResponseEntity<List<BookTransactionResponse>> findByBookId(@PathVariable("book-id") Integer bookId) {
        return ResponseEntity.ok(this.service.findByBookingId(bookId));
    }
}
