package com.ooad.service;

import com.ooad.dao.PatientReportDAO;
import com.ooad.model.PatientDate;
import com.ooad.model.PatientReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("patientReportService")
@Transactional
public class PatientReportServiceImpl implements PatientReportService {

    @Autowired
    PatientReportDAO dao;

    public PatientReport findById(int patientId, String date) {
        PatientDate patientDate = new PatientDate();
        patientDate.setId(patientId);
        patientDate.setDate(date);
        return dao.findById(patientDate);
    }

    public void save(PatientReport patientReport) {
        dao.save(patientReport);
    }

    public void update(PatientReport patientReport) {
        PatientReport entity = dao.findById(patientReport.getPatientDate());
        if (entity != null) {
            entity.setDiagnosis(patientReport.getDiagnosis());
            entity.setPatientDate(patientReport.getPatientDate());
            entity.setPrescription(patientReport.getPrescription());
        }
    }

    public void delete(int patientId, String date) {
        PatientDate patientDate = new PatientDate();
        patientDate.setId(patientId);
        patientDate.setDate(date);
        dao.delete(patientDate);
    }

    public List<PatientReport> findAllReportsForId(int id) {
        return dao.findAllReportsForId(id);
    }
}
