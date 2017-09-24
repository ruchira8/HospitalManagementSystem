package com.ooad.service;

import com.ooad.dao.UserDAO;
import com.ooad.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO dao;
    public User findById(String username) {
        return dao.findById(username);
    }

    public void saveUser(User user) {
        dao.saveUser(user);
    }

    public void updateUser(User user) {
        User entity = dao.findById(user.getUsername());
        if(entity!=null){
            entity.setPassword(user.getPassword());
            entity.setUserType(user.getUserType());
        }
    }

    public void deleteUser(int id) {
        dao.deleteUser(id);
    }

    public List<User> findAllUsers() {
        return dao.findAllUsers();
    }
}
