package com.ooad.controller;

import com.ooad.model.Patient;
import com.ooad.model.User;
import com.ooad.service.PatientService;
import com.ooad.service.UserService;
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
@RequestMapping("/patients")
@ComponentScan("com.ooad")
public class PatientController {
    @Autowired
    PatientService patientService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/add")
    public String addPatient() {
        return "addPatient";
    }

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String listPatients(ModelMap model) {
        List<Patient> patients = patientService.findAllPatients();
        model.addAttribute("patients", patients);
        return "allPatients";
    }

    @RequestMapping(value = {"/edit/{id}"}, method = RequestMethod.GET)
    public String edit(@PathVariable String id, ModelMap model) {
        Patient patient = patientService.findById(Integer.parseInt(id));
        model.addAttribute("patient", patient);
        return "editPatient";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("id"));
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        Patient patient = patientService.findById(id);
        if (patient != null) {
            User user = new User();
            user.setUserType("Patient");
            user.setUsername(userName);
            user.setId(id);
            user.setPassword(password);
            userService.saveUser(user);
            modelAndView.setViewName("patientHome");
            modelAndView.addObject("patient", patient);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/addNew", method = RequestMethod.POST)
    public String addPatient(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        patientService.savePatient(getPatientFromFormData(request));
        List<Patient> patients = patientService.findAllPatients();
        modelAndView.addObject("patients", patients);
        return "allPatients";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String edit(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        patientService.updatePatient(getPatientFromFormData(request));
        List<Patient> patients = patientService.findAllPatients();
        modelAndView.addObject("patients", patients);
        return "allPatients";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id, ModelMap model) {
        patientService.deletePatient(id);
        List<Patient> patients = patientService.findAllPatients();
        model.addAttribute("patients", patients);
        return "allPatients";
    }

    private Patient getPatientFromFormData(HttpServletRequest request){
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String emailId = request.getParameter("emailId");
        Patient patient = new Patient();
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setAge(age);
        patient.setGender(gender);
        patient.setPhone(phone);
        patient.setAddress(address);
        patient.setEmailId(emailId);
        return patient;
    }
}