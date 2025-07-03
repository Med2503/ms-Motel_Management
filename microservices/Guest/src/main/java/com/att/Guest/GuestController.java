package com.att.Guest;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/guests")
public class GuestController {
    private final GuestService service;

    public GuestController(GuestService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> createGuest(@RequestBody @Valid GuestRequest request) {
        return ResponseEntity.ok(this.service.createGuest(request));
    }

    @PutMapping
    public ResponseEntity<Void> updateGuest(@RequestBody @Valid GuestRequest request) {
        this.service.updateGuest(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<GuestResponse>> findAll() {
        return ResponseEntity.ok(this.service.findAll());
    }

    @GetMapping("/exists/{guest-id}")
    public ResponseEntity<Boolean> existsByById(@PathVariable("guest-id") String guestId) {
        return ResponseEntity.ok(this.service.existsById(guestId));
    }

    @GetMapping("/{guest-id}")
    public ResponseEntity<GuestResponse> findById(@PathVariable("guest-id") String guestId) {
        return ResponseEntity.ok(this.service.findById(guestId));
    }

    @DeleteMapping("/{guest-id}")
    public ResponseEntity<Void> delete(@PathVariable("guest-id") String guestId) {
        this.service.deleteGuest(guestId);
        return ResponseEntity.accepted().build();
    }
}
