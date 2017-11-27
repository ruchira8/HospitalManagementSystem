package com.ooad.dao;

import com.ooad.model.User;

import java.util.List;

public interface UserDAO {

    User findByUserName(String username);

    void saveUser(User user);

    void deleteUser(int id);

    List<User> findAllUsers();

}
