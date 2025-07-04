package com.att.Book;


import com.att.Booking.BookTransactionRequest;
import com.att.Booking.BookTransactionService;
import com.att.exception.GuestNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class bookingService {

    private final GuestClient guestClient;
    private final RoomClient RoomClient;

    private final BookingRepository repository;

    private final BookingMapper mapper;

    private final BookTransactionService bookTransactionService;


    public bookingService(GuestClient guestClient, com.att.Book.RoomClient roomClient, BookingRepository repository, BookingMapper mapper, BookTransactionService service) {
        this.guestClient = guestClient;
        RoomClient = roomClient;
        this.repository = repository;
        this.mapper = mapper;
        this.bookTransactionService = service;
    }

    @Transactional
    public Integer create(BookRequest request) {
        var guest = this.guestClient.findGuestById(request.guestId())
                .orElseThrow(() -> new GuestNotFoundException("cannot find guest with given id"));

        var bookedRooms = RoomClient.bookRooms(request.rooms());

        var booking = this.repository.save(mapper.toBooking(request));

        for (RoomBookedRequest roomBookedRequest : request.rooms()) {
            bookTransactionService.saveBookTransaction(
                    new BookTransactionRequest(null,
                            booking.getId(),
                            roomBookedRequest.roomId(),
                            roomBookedRequest.beds()
                    ));
        }


    }

}

