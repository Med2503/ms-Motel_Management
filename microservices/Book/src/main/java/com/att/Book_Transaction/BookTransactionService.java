package com.att.Book_Transaction;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookTransactionService {

    private final BookTransactionRepository repository;
    private final BookTransactionMapper mapper;

    public BookTransactionService(BookTransactionRepository repository, BookTransactionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public Integer saveBookTransaction(BookTransactionRequest request) {
        var bookTransaction = mapper.toBookTransaction(request);
        return repository.save(bookTransaction).getId();
    }


    public List<BookTransactionResponse> findByBookingId(Integer bookingId) {
        return repository.findAllByBookingId(bookingId)
                .stream()
                .map(mapper::toBookTransactionResponse)
                .collect(Collectors.toList());
    }
}
