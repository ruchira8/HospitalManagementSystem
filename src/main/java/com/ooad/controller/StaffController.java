package com.ooad.controller;

import com.ooad.model.Staff;
import com.ooad.service.PatientReportService;
import com.ooad.service.StaffService;
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
@RequestMapping("/staff")
@ComponentScan("com.ooad")
public class StaffController {
    @Autowired
    StaffService staffService;

    @Autowired
    PatientReportService patientReportService;

    @RequestMapping(value = {"/edit/{id}"}, method = RequestMethod.GET)
    public String edit(@PathVariable String id, ModelMap model) {
        Staff staff = staffService.findById(Integer.parseInt(id));
        model.addAttribute("staff", staff);
        return "editStaff";
    }

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String listAdmins(ModelMap model) {
        List<Staff> staff = staffService.findAllStaff();
        model.addAttribute("staffs", staff);
        return "allStaff";
    }

    @RequestMapping(value = {"/search"}, method = RequestMethod.POST)
    public String search(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        String searchTerm = request.getParameter("searchTerm");
        List<Staff> staff = staffService.findStaff(searchTerm);
        model.addAttribute("staffs", staff);
        return "allStaff";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        Staff staff = staffService.findByUserName(userName);
        if (staff == null) {
            Staff newStaff = parseStaff(request);
            newStaff.setUsername(userName);
            newStaff.setPassword(password);
            staffService.saveStaff(newStaff);
            modelAndView.setViewName("staffHome");
            modelAndView.addObject("staff", newStaff);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String edit(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        Staff updatedStaff = parseStaff(request);
        updatedStaff.setId(id);
        staffService.updateStaff(updatedStaff);
        List<Staff> allStaff = staffService.findAllStaff();
        modelAndView.addObject("staff", allStaff);
        return "allStaff";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id, ModelMap model) {
        staffService.deleteStaff(id);
        List<Staff> staff = staffService.findAllStaff();
        model.addAttribute("staff", staff);
        return "allStaff";
    }

    private Staff parseStaff(HttpServletRequest request) {
        Staff staff = new Staff();
        staff.setFirstName(request.getParameter("firstName"));
        staff.setLastName(request.getParameter("lastName"));
        if (!"".equals(request.getParameter("age")) && request.getParameter("age") != null) {
            staff.setAge(Integer.parseInt(request.getParameter("age")));
        }
        staff.setGender(request.getParameter("gender"));
        staff.setPhone(request.getParameter("phone"));
        staff.setAddress(request.getParameter("address"));
        staff.setEmailId(request.getParameter("emailId"));
        staff.setDesignation(request.getParameter("designation"));
        return staff;
    }
}
