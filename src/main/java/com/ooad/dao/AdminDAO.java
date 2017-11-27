package com.ooad.dao;

import com.ooad.model.Admin;

import java.util.List;

public interface AdminDAO {

    Admin findById(int id);

    Admin findByUserName(String username);

    Admin save(Admin admin);

    void delete(int id);

    List<Admin> findAllAdmins();

    List<Admin> findAdmins(String searchTerm);
}
