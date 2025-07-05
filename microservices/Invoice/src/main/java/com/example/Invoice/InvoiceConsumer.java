package com.example.Invoice;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class InvoiceConsumer {
    private final InvoiceRepository repository;

    public InvoiceConsumer(InvoiceRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "booking-topic")
    public void InvoiceRegister(BookingBiLL bookingBiLL) {

        repository.save(
                Invoice.builder()
                        .registerDate(LocalDateTime.now())
                        .bookingBiLL(bookingBiLL)
                        .build()
        );

    }

}
