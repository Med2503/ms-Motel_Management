package com.att.Room;


import com.att.exception.RoomBookedException;
import com.att.exception.RoomNotFoundException;
import com.att.exception.RoomRequestException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {
    private final RoomRepository repository;
    private final RoomMapper mapper;

    public RoomService(RoomRepository repository, RoomMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Integer createRoom(RoomRequest request) {

        var room = mapper.toRoom(request);
        return repository.save(room).getId();

    }

    @Transactional(rollbackOn = RoomRequestException.class)
    public List<RoomBookedResponse> bookRooms(List<RoomBookedRequest> request) {
        var roomIds = request.stream()
                .map(RoomBookedRequest::roomId)
                .toList();
        var roomsList = repository.findAllByIdInOrderById(roomIds);


        if (roomIds.size() != roomsList.size()) {
            throw new RoomBookedException("Cannot find selected Room !");
        }
        var roomsRequest = request.stream()
                .sorted(Comparator.comparing(RoomBookedRequest::roomId))
                .toList();
        var bookedRooms = new ArrayList<RoomBookedResponse>();

        for (int i = 0; i < roomsList.size(); i++) {
            var room = roomsList.get(i);
            var roomRequest = roomsRequest.get(i);
            if (room.getAvailablePlaces() < roomRequest.places()) {
                throw new RoomRequestException("no available places in selected room " + roomRequest.roomId());
            }

            var newAvailablePlaces = room.getAvailablePlaces() - roomRequest.places();
            room.setAvailablePlaces(newAvailablePlaces);
            repository.save(room);
            bookedRooms.add(mapper.toRoomBookedResponse(room, roomRequest.places()));


        }
        return bookedRooms;
    }

    public RoomResponse findById(Integer roomId) {
        return repository.findById(roomId)
                .map(mapper::toRoomResponse)
                .orElseThrow(() -> new RoomNotFoundException("No Room found with id " + roomId));
    }

    public List<RoomResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toRoomResponse)
                .collect(Collectors.toList());

    }

    public List<RoomResponse> getAvailableRoomsByType(Integer roomTypeId) {
        List<Room> rooms = repository.findALLByRoomTypeId(roomTypeId);
        return rooms.stream()
                .map(mapper::toRoomResponse)
                .toList();
    }
}

