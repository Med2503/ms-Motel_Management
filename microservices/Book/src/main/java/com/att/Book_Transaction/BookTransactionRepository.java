package com.att.Book_Transaction;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookTransactionRepository extends JpaRepository<BookTransaction, Integer> {

    List<BookTransaction> findAllByBookingId(Integer bookingId);

}
