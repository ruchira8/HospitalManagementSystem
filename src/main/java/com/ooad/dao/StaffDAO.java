package com.ooad.dao;

import com.ooad.model.Staff;

import java.util.List;

public interface StaffDAO {
    Staff findById(int id);

    Staff findByUserName(String username);

    Staff save(Staff staff);

    void delete(int id);

    List<Staff> findAllStaff();

    List<Staff> findStaff(String searchTerm);
}
