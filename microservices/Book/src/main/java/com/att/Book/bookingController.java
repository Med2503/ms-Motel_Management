package com.att.Book;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookings")
public class bookingController {

    private bookingService service;

    public bookingController(bookingService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Integer> create(@RequestBody @Valid BookRequest request) {
        return ResponseEntity.ok(this.service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> findAll() {
        return ResponseEntity.ok(this.service.findAllBookings());
    }

    @GetMapping("/{booking-id}")
    public ResponseEntity<BookResponse> findById(@PathVariable("booking-id") Integer bookingId) {
        return ResponseEntity.ok(this.service.findById(bookingId));
    }
}
