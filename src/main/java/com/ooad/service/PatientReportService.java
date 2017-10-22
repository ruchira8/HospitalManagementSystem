package com.ooad.service;

import com.ooad.model.PatientReport;

import java.util.List;

public interface PatientReportService {
    PatientReport findById(int patientId, String date);

    void save(PatientReport patientReport);

    void update(PatientReport patientReport);

    void delete(int patientId, String date);

    List<PatientReport> findAllReportsForId(int id);
}
