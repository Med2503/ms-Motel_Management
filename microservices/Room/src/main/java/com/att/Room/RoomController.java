package com.att.Room;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {

    private RoomService service;

    public RoomController(RoomService roomService) {
        this.service = roomService;
    }

    @PostMapping
    public ResponseEntity<Integer> createRoom(@RequestBody @Valid RoomRequest request) {
        return ResponseEntity.ok(service.createRoom(request));
    }

    @PostMapping("/book")
    public ResponseEntity<List<RoomBookedResponse>> bookRooms(@RequestBody List<RoomBookedRequest> request) {
        return ResponseEntity.ok(service.bookRooms(request));
    }

    @GetMapping("/{room-id}")
    public ResponseEntity<RoomResponse> findById(@PathVariable("room-id") Integer roomId) {
        return ResponseEntity.ok(service.findById(roomId));
    }

    @GetMapping
    public ResponseEntity<List<RoomResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/available/{roomType-id}")
    public ResponseEntity<List<RoomResponse>> getAvailableRoomsByType(@PathVariable("roomType-id") @Min(1) Integer roomTypeId) {
        return ResponseEntity.ok(service.getAvailableRoomsByType(roomTypeId));
    }

}
