package com.ooad.controller;

import com.ooad.model.PatientDate;
import com.ooad.model.PatientReport;
import com.ooad.service.PatientReportService;
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
@RequestMapping("/staff/patient/reports")
@ComponentScan("com.ooad")
public class PatientReportController {
    @Autowired
    PatientReportService patientReportService;

    @RequestMapping(value = "/add/{id}")
    public String addReport(ModelMap model, @PathVariable int id) {
        model.addAttribute("id", id);
        return "addReport";
    }

    @RequestMapping(value = "/addNewReport/{id}", method = RequestMethod.POST)
    public String addPatientReport(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        PatientReport updatedPatientReport = parsePatientReportFromFormData(request);
        PatientDate patientDate = new PatientDate();
        patientDate.setId(id);
        patientDate.setDate(request.getParameter("date"));
        updatedPatientReport.setPatientDate(patientDate);
        patientReportService.save(updatedPatientReport);
        List<PatientReport> reports = patientReportService.findAllReportsForId(id);
        modelAndView.addObject("reports", reports);
        modelAndView.addObject("pId", id);
        return "patientReports";
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public String getPatientReports(@PathVariable int id, ModelMap model) {
        List<PatientReport> reports = patientReportService.findAllReportsForId(id);
        model.addAttribute("reports", reports);
        model.addAttribute("pId", id);
        return "patientReports";
    }

    @RequestMapping(value = "/delete/{id}/{date}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id, @PathVariable("date") String date, ModelMap model) {
        patientReportService.delete(id, date);
        List<PatientReport> reports = patientReportService.findAllReportsForId(id);
        model.addAttribute("reports", reports);
        model.addAttribute("pId", id);
        return "patientReports";
    }

    @RequestMapping(value = {"/edit/{id}/{date}"}, method = RequestMethod.GET)
    public String editPatient(@PathVariable("id") int id, @PathVariable("date") String date, ModelMap model) {
        PatientReport patientReport = patientReportService.findById(id, date);
        model.addAttribute("report", patientReport);
        model.addAttribute("id", id);
        return "editReport";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateReport(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        PatientReport updatedPatientReport = parsePatientReportFromFormData(request);
        PatientDate patientDate = new PatientDate();
        patientDate.setId(id);
        patientDate.setDate(request.getParameter("date"));
        updatedPatientReport.setPatientDate(patientDate);
        patientReportService.update(updatedPatientReport);
        List<PatientReport> reports = patientReportService.findAllReportsForId(id);
        modelAndView.addObject("reports", reports);
        modelAndView.addObject("pId", id);
        return "patientReports";
    }

    private PatientReport parsePatientReportFromFormData(HttpServletRequest request) {
        PatientReport patientReport = new PatientReport();
        patientReport.setPrescription(request.getParameter("prescription"));
        patientReport.setDiagnosis(request.getParameter("diagnosis"));
        return patientReport;
    }
}
