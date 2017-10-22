package com.ooad.service;


import com.ooad.model.Room;

import java.util.List;

public interface RoomService {
    Room findById(int id);

    Room saveRoom(Room room);

    void updateRoom(Room room);

    void deleteRoom(int id);

    List<Room> findAllRooms();
}
