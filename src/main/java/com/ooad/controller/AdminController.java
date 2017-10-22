package com.ooad.controller;

import com.ooad.model.Admin;
import com.ooad.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/admin")
@ComponentScan("com.ooad")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping(value = {"/edit/{id}"}, method = RequestMethod.GET)
    public String edit(@PathVariable String id, ModelMap model) {
        Admin admin = adminService.findById(Integer.parseInt(id));
        model.addAttribute("admin", admin);
        return "editAdmin";
    }

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String listAdmins(ModelMap model) {
        List<Admin> admins = adminService.findAllAdmins();
        model.addAttribute("admins", admins);
        return "allAdmins";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        Admin admin = adminService.findByUserName(userName);
        if (admin == null) {
            Admin newAdmin = getAdminFromFormData(request);
            newAdmin.setUsername(userName);
            newAdmin.setPassword(password);
            adminService.saveAdmin(newAdmin);
            modelAndView.setViewName("adminHome");
            modelAndView.addObject("admin", newAdmin);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String edit(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        Admin updatedAdmin = getAdminFromFormData(request);
        updatedAdmin.setId(id);
        adminService.updateAdmin(updatedAdmin);
        List<Admin> admins = adminService.findAllAdmins();
        modelAndView.addObject("admins", admins);
        return "allAdmins";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id, ModelMap model) {
        adminService.deleteAdmin(id);
        List<Admin> admins = adminService.findAllAdmins();
        model.addAttribute("admins", admins);
        return "allAdmins";
    }

    private Admin getAdminFromFormData(HttpServletRequest request) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String emailId = request.getParameter("emailId");
        String designation = request.getParameter("designation");
        Admin admin = new Admin();
        admin.setFirstName(firstName);
        admin.setLastName(lastName);
        admin.setAge(age);
        admin.setGender(gender);
        admin.setPhone(phone);
        admin.setAddress(address);
        admin.setEmailId(emailId);
        admin.setDesignation(designation);
        return admin;
    }
}
