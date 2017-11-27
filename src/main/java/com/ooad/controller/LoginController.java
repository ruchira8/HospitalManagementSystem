package com.ooad.controller;

import com.ooad.dao.UserDAO;
import com.ooad.model.Admin;
import com.ooad.model.Patient;
import com.ooad.model.Staff;
import com.ooad.service.AdminService;
import com.ooad.service.PatientService;
import com.ooad.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("roles")
public class LoginController {

    @Autowired
    AdminService adminService;
    @Autowired
    StaffService staffService;
    @Autowired
    UserDAO userService;
    @Autowired
    PatientService patientService;
    @Autowired
    MessageSource messageSource;
    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;

    @RequestMapping(value = "/")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        String userName = getPrincipal();
        Patient patient = patientService.findByUserName(userName);
        if (patient != null) {
            modelAndView.setViewName("patientHome");
            modelAndView.addObject("patient", patient);
        } else {
            Admin admin = adminService.findByUserName(userName);
            if (admin != null) {
                modelAndView.setViewName("adminHome");
                modelAndView.addObject("admin", admin);
            } else {
                modelAndView.setViewName("home");
            }
        }
        return modelAndView;
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

    @RequestMapping(value = "/registerStaff")
    public String registerStaff() {
        return "registerStaff";
    }

    @RequestMapping(value = "/registerAdmin")
    public String registerAdmin() {
        return "registerAdmin";
    }

    @RequestMapping(value = "/homepage", method = RequestMethod.GET)
    public ModelAndView home(@RequestParam(value = "error", required = false) String error,
                             @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView modelAndView = new ModelAndView();
        if (error != null) {
            modelAndView.addObject("error", "Invalid Credentials provided.");
            modelAndView.setViewName("login");
        } else if (logout != null) {
            modelAndView.addObject("message", "You have been logged out successfully.");
            modelAndView.setViewName("login");
        } else {
            String userName = getPrincipal();
            Patient patient = patientService.findByUserName(userName);
            if (patient != null) {
                modelAndView.setViewName("patientHome");
                modelAndView.addObject("patient", patient);
            } else {
                Admin admin = adminService.findByUserName(userName);
                if (admin != null) {
                    modelAndView.setViewName("adminHome");
                    modelAndView.addObject("admin", admin);
                } else {
                    Staff staff = staffService.findByUserName(userName);
                    if (staff != null) {
                        modelAndView.setViewName("staffHome");
                        modelAndView.addObject("staff", staff);
                    }
                }
            }

        }
        return modelAndView;
    }

    private String getPrincipal() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }
}
