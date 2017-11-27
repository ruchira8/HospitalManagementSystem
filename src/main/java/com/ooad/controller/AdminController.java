package com.ooad.controller;

import com.ooad.model.Admin;
import com.ooad.model.Patient;
import com.ooad.service.AdminService;
import com.ooad.service.PatientReportService;
import com.ooad.service.PatientService;
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

    @Autowired
    PatientService patientService;

    @Autowired
    PatientReportService patientReportService;

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

    @RequestMapping(value = {"/search"}, method = RequestMethod.POST)
    public String search(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        String searchTerm = request.getParameter("searchTerm");
        List<Admin> admins = adminService.findAdmins(searchTerm);
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

    @RequestMapping(value = {"/editPatient/{id}"}, method = RequestMethod.GET)
    public String editPatient(@PathVariable String id, ModelMap model) {
        Patient patient = patientService.findById(Integer.parseInt(id));
        model.addAttribute("patient", patient);
        return "editPatientAdmin";
    }

    private Admin getAdminFromFormData(HttpServletRequest request) {
        Admin admin = new Admin();
        admin.setFirstName(request.getParameter("firstName"));
        admin.setLastName(request.getParameter("lastName"));
        if (!"".equals(request.getParameter("age")) && request.getParameter("age") != null) {
            admin.setAge(Integer.parseInt(request.getParameter("age")));
        }
        admin.setGender(request.getParameter("gender"));
        admin.setPhone(request.getParameter("phone"));
        admin.setAddress(request.getParameter("address"));
        admin.setEmailId(request.getParameter("emailId"));
        return admin;
    }
}
