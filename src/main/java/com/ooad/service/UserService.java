package com.ooad.service;

import com.ooad.model.User;

import java.util.List;

public interface UserService {

    User findById(String username);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

    List<User> findAllUsers();

}
