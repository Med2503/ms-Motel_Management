package com.att.Type;


import com.att.Room.Room;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class RoomType {
    @Id
    @GeneratedValue
    private Integer id;
    private String type;
    private String description;
    @OneToMany(mappedBy = "roomType", cascade = CascadeType.REMOVE)
    private List<Room> rooms;


}
