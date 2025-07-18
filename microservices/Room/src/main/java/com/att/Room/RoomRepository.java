package com.att.Room;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> findAllByIdInOrderById(List<Integer> roomIds);
    List<Room> findALLByRoomTypeId(Integer roomTypeId);
}
