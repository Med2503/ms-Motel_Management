package com.att.config;


import com.att.Book.BookingBiLL;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class BookingKafkaProducer {

    private final KafkaTemplate<String, BookingBiLL> kafkaTemplate;

    public BookingKafkaProducer(KafkaTemplate<String, BookingBiLL> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendBookingBiLL(BookingBiLL biLL) {
        Message<BookingBiLL> message = MessageBuilder
                .withPayload(biLL)
                .setHeader(KafkaHeaders.TOPIC, "booking-topic")
                .build();
        kafkaTemplate.send(message);


    }


}
