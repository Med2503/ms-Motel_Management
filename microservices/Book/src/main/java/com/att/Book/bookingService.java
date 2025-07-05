package com.att.Book;


import com.att.Booking.BookTransactionRequest;
import com.att.Booking.BookTransactionService;
import com.att.config.BookingKafkaProducer;
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
    private final BookingKafkaProducer kafkaProducer;


    public bookingService(GuestClient guestClient, com.att.Book.RoomClient roomClient, BookingRepository repository, BookingMapper mapper, BookTransactionService bookTransactionService, BookingKafkaProducer producer) {
        this.guestClient = guestClient;
        RoomClient = roomClient;
        this.repository = repository;
        this.mapper = mapper;
        this.bookTransactionService = bookTransactionService;
        this.kafkaProducer = producer;
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

        kafkaProducer.sendBookingBiLL(
                new BookingBiLL(
                        request.reference(),
                        request.amount(),
                        request.method(),
                        guest,
                        bookedRooms
                )
        );
        return booking.getId();

    }

}

