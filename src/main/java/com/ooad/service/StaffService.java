package com.ooad.service;

import com.ooad.model.Staff;

import java.util.List;


public interface StaffService {
    Staff findById(int id);

    Staff findByUserName(String username);

    Staff saveStaff(Staff staff);

    void updateStaff(Staff staff);

    void deleteStaff(int staffId);

    List<Staff> findAllStaff();

    List<Staff> findStaff(String searchTerm);
}
