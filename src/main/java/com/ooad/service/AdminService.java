package com.ooad.service;


import com.ooad.model.Admin;

import java.util.List;

public interface AdminService {
    Admin findById(int id);

    Admin saveAdmin(Admin admin);

    void updateAdmin(Admin admin);

    void deleteAdmin(int admin);

    List<Admin> findAllAdmins();
}