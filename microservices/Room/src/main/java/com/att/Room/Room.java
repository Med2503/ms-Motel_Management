package com.att.Room;


import com.att.Type.RoomType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Room {


    @Id
    @GeneratedValue
    private Integer id;
    private String description;
    private double availablePlaces;
    @Column(precision = 19,scale = 4)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "roomType_id")
    private RoomType roomType;
}
