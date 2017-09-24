package com.ooad.controller;

import com.ooad.model.User;
import com.ooad.service.AdminService;
import com.ooad.service.PatientService;
import com.ooad.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {
    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;
    @Autowired
    PatientService patientService;

    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/register")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/registerPatient")
    public String registerPatient() {
        return "registerPatient";
    }

    @RequestMapping(value = "/registerAdmin")
    public String registerAdmin() {
        return "registerAdmin";
    }

    @RequestMapping(value = "/login/verify", method = RequestMethod.POST)
    public ModelAndView verify(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        User user = userService.findById(userName);
        if(user != null && user.getPassword().equals(password)){
            if(user.getUserType().equalsIgnoreCase("admin")){
                modelAndView.setViewName("adminHome");
                modelAndView.addObject("admin",adminService.findById(user.getId()));
            } else {
                modelAndView.setViewName("patientHome");
                modelAndView.addObject("patient", patientService.findById(user.getId()));
            }
        }
        return modelAndView;
    }
}
