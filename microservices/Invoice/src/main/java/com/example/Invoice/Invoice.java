package com.example.Invoice;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document
public class Invoice {
    @Id
    private String id;
    private LocalDateTime registerDate;
    private BookingBiLL bookingBiLL;


}
