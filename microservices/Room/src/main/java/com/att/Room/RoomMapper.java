package com.att.Room;

import com.att.Type.RoomType;
import org.springframework.stereotype.Service;

@Service
public class RoomMapper {
    public Room toRoom(RoomRequest request) {
        return Room.builder()
                .id(request.id())
                .description(request.description())
                .availablePlaces(request.availablePlaces())
                .price(request.price())
                .roomType(RoomType.builder()
                        .id(request.RoomTypeId())
                        .build())
                .build();

    }

    public RoomBookedResponse toRoomBookedResponse(Room room, double places) {
        return new RoomBookedResponse(
                room.getId(),
                room.getDescription(),
                room.getPrice(),
                places
        );
    }

    public RoomResponse toRoomResponse(Room room) {
        return new RoomResponse(
                room.getId(),
                room.getDescription(),
                room.getAvailablePlaces(),
                room.getPrice(),
                room.getRoomType().getId(),
                room.getRoomType().getType(),
                room.getRoomType().getDescription()
        );
    }
}
