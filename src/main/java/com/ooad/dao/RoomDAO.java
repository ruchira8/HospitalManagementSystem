package com.ooad.dao;

import com.ooad.model.Room;

import java.util.List;


public interface RoomDAO {
    Room findById(int id);

    Room save(Room room);

    void delete(int id);

    List<Room> findAllRooms();
}
