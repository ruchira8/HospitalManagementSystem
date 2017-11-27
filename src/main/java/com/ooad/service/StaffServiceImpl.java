package com.ooad.service;

import com.ooad.dao.StaffDAO;
import com.ooad.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("staffService")
@Transactional
public class StaffServiceImpl implements StaffService {
    @Autowired
    StaffDAO staffDAO;

    public Staff findById(int id) {
        return staffDAO.findById(id);
    }

    public Staff findByUserName(String username) {
        return staffDAO.findByUserName(username);
    }

    public Staff saveStaff(Staff staff) {
        return staffDAO.save(staff);
    }

    public void updateStaff(Staff staff) {
        Staff entity = staffDAO.findById(staff.getId());
        System.out.println(entity);
        if (entity != null) {
            entity.setFirstName(staff.getFirstName());
            entity.setLastName(staff.getLastName());
            entity.setAge(staff.getAge());
            entity.setPhone(staff.getPhone());
            entity.setGender(staff.getGender());
            entity.setAddress(staff.getAddress());
            entity.setEmailId(staff.getEmailId());
            entity.setDesignation(staff.getDesignation());
        }
    }

    public void deleteStaff(int staffId) {
        staffDAO.delete(staffId);
    }

    public List<Staff> findAllStaff() {
        return staffDAO.findAllStaff();
    }

    public List<Staff> findStaff(String searchTerm) {
        return staffDAO.findStaff(searchTerm);
    }
}
