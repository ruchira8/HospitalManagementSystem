package com.ooad.service;

import com.ooad.dao.AdminDAO;
import com.ooad.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminDAO dao;

    public Admin findById(int id) {
        return dao.findById(id);
    }

    public Admin findByUserName(String username) {
        return dao.findByUserName(username);
    }

    public Admin saveAdmin(Admin admin) {
        return dao.save(admin);
    }

    public void updateAdmin(Admin admin) {
        Admin entity = dao.findById(admin.getId());
        if (entity != null) {
            entity.setFirstName(admin.getFirstName());
            entity.setLastName(admin.getLastName());
            entity.setAge(admin.getAge());
            entity.setPhone(admin.getPhone());
            entity.setGender(admin.getGender());
            entity.setAddress(admin.getAddress());
            entity.setEmailId(admin.getEmailId());
        }
    }

    public void deleteAdmin(int id) {
        dao.delete(id);
    }

    public List<Admin> findAllAdmins() {
        return dao.findAllAdmins();
    }

    public List<Admin> findAdmins(String searchTerm) {
        return dao.findAdmins(searchTerm);
    }
}
