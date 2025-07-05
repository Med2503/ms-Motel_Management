package com.example.Invoice;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InvoiceConsumer {
    private final InvoiceRepository repository;

    @KafkaListener(topics = "booking-topic")
    public void InvoiceConsumer(BookingBiLL bookingBiLL) {

        repository.save(
                Invoice.builder()

                        .build()
        );

    }

}
