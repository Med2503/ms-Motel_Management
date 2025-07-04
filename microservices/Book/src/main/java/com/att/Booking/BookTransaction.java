package com.att.Booking;

import com.att.Book.Booking;
import jakarta.persistence.*;
import lombok.*;

import java.awt.print.Book;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class BookTransaction {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    private Integer roomId;
    private double beds;
}
