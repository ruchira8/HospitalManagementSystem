package com.ooad.controller;

import com.ooad.model.Patient;
import com.ooad.model.PatientReport;
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
@RequestMapping("/patients")
@ComponentScan("com.ooad")
public class PatientController {
    @Autowired
    PatientService patientService;

    @Autowired
    PatientReportService patientReportService;

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

    @RequestMapping(value = {"/search"}, method = RequestMethod.POST)
    public String search(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        String searchTerm = request.getParameter("searchTerm");
        List<Patient> patients = patientService.findPatients(searchTerm);
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
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        Patient patient = patientService.findByUserName(userName);
        if (patient == null) {
            Patient newPatient = getPatientFromFormData(request);
            newPatient.setUsername(userName);
            newPatient.setPassword(password);
            patientService.savePatient(newPatient);
            modelAndView.setViewName("patientHome");
            modelAndView.addObject("patient", newPatient);
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

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String edit(@PathVariable int id,HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        Patient updatedPatient = getPatientFromFormData(request);
        updatedPatient.setId(id);
        patientService.updatePatient(updatedPatient);
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

    @RequestMapping(value = {"/reports/{id}"}, method = RequestMethod.GET)
    public String getPatientReports(@PathVariable int id, ModelMap model) {
        List<PatientReport> reports = patientReportService.findAllReportsForId(id);
        model.addAttribute("reports", reports);
        return "viewPatientReports";
    }

    private Patient getPatientFromFormData(HttpServletRequest request) {
        Patient patient = new Patient();
        patient.setFirstName(request.getParameter("firstName"));
        patient.setLastName(request.getParameter("lastName"));
        if(request.getParameter("age")!= null){
            patient.setAge(Integer.parseInt(request.getParameter("age")));
        }
        patient.setGender(request.getParameter("gender"));
        patient.setPhone(request.getParameter("phone"));
        patient.setAddress(request.getParameter("address"));
        patient.setEmailId(request.getParameter("emailId"));
        return patient;
    }
}