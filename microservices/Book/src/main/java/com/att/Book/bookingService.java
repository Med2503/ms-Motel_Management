package com.att.Book;


import com.att.Book_Transaction.BookTransactionRequest;
import com.att.Book_Transaction.BookTransactionService;
import com.att.config.BookingBiLL;
import com.att.config.BookingKafkaProducer;
import com.att.exception.BookingNotFoundException;
import com.att.exception.GuestNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<BookResponse> findAllBookings() {
        return this.repository.findAll()
                .stream()
                .map(mapper::toBookResponse)
                .collect(Collectors.toList());
    }

    public BookResponse findById(Integer bookingId) {
        return this.repository
                .findById(bookingId)
                .map(mapper::toBookResponse)
                .orElseThrow(() -> new BookingNotFoundException(String.format("cannot find booking with id", bookingId)));


    }
}

