package com.att.Book;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
