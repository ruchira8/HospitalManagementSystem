package com.ooad.controller;

import com.ooad.model.Admin;
import com.ooad.model.Patient;
import com.ooad.service.AdminService;
import com.ooad.service.PatientService;
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
        Patient patient = patientService.findByUserName(userName);
        if (patient != null && patient.getPassword().equals(password)) {
            modelAndView.setViewName("patientHome");
            modelAndView.addObject("patient", patient);
        } else {
            Admin admin = adminService.findByUserName(userName);
            if (admin != null && admin.getPassword().equals(password)) {
                modelAndView.setViewName("adminHome");
                modelAndView.addObject("admin", admin);
            }
        }
        return modelAndView;
    }
}
