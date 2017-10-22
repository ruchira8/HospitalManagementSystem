package com.ooad.service;

import com.ooad.dao.RoomDAO;
import com.ooad.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roomService")
@Transactional
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomDAO dao;

    public Room findById(int id) {
        return dao.findById(id);
    }

    public Room saveRoom(Room room) {
        return dao.save(room);
    }

    public void updateRoom(Room room) {
        Room entity = dao.findById(room.getId());
        if (entity != null) {
            entity.setPatientId(room.getId());
            entity.setStatus(room.getStatus());
        }
    }

    public void deleteRoom(int id) {
        dao.delete(id);
    }

    public List<Room> findAllRooms() {
        return dao.findAllRooms();
    }
}
