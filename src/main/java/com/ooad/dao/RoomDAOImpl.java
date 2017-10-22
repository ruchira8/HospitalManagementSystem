package com.ooad.dao;

import com.ooad.model.Room;
import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("roomDAO")
public class RoomDAOImpl extends AbstractDAO<Integer, Room> implements RoomDAO {
    public Room findById(int id) {
        return getByKey(id);
    }

    public Room save(Room room) {
        persist(room);
        return room;
    }

    public void delete(int id) {
        Query query = getSession().createSQLQuery("delete from Room where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    public List<Room> findAllRooms() {
        Criteria criteria = createEntityCriteria();
        return (List<Room>) criteria.list();
    }
}
