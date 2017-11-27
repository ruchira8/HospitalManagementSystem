package com.ooad.dao;

import com.ooad.model.Staff;
import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("staffDao")
public class StaffDAOImpl extends AbstractDAO<Integer, Staff> implements StaffDAO {
    public Staff findById(int id) {
        return getByKey(id);
    }

    public Staff findByUserName(String username) {
        List<Staff> allStaff = findAllStaff();
        System.out.println(allStaff);
        for (Staff staff : allStaff) {
            if (staff.getUsername().equals(username)) {
                return staff;
            }
        }
        return null;
    }

    public Staff save(Staff staff) {
        persist(staff);
        return staff;
    }

    public void delete(int id) {
        Query query = getSession().createSQLQuery("delete from User where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    public List<Staff> findAllStaff() {
        Criteria criteria = createEntityCriteria();
        return (List<Staff>) criteria.list();
    }

    public List<Staff> findStaff(String searchTerm) {
        String regex = searchTerm.toLowerCase();
        List<Staff> allStaff = findAllStaff();
        List<Staff> staff = new ArrayList<Staff>();
        for (Staff staff1 : allStaff) {
            if (staff1.getFirstName().toLowerCase().contains(regex) || staff1.getLastName().toLowerCase().contains
                    (regex) || staff1.getDesignation().toLowerCase().contains(regex)) {
                staff.add(staff1);
            }
        }
        return staff;
    }
}
