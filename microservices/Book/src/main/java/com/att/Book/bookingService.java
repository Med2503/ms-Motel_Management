package com.att.Book;


import com.att.exception.GuestNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class bookingService {

    private final GuestClient guestClient;
    private final RoomClient RoomClient;

    public bookingService(GuestClient guestClient, com.att.Book.RoomClient roomClient) {
        this.guestClient = guestClient;
        RoomClient = roomClient;
    }

    @Transactional
    public Integer create(BookRequest request) {
        var guest = this.guestClient.findGuestById(request.guestId())
                .orElseThrow(() -> new GuestNotFoundException("cannot find guest with given id"));

        var bookedRooms = RoomClient.bookRooms(request.rooms());

    }

}

