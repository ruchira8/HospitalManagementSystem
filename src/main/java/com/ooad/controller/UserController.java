package com.ooad.controller;

import com.ooad.model.User;
import com.ooad.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/users")
@ComponentScan("com.ooad")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String listEmployees(ModelMap model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "allUsers";
    }
}
