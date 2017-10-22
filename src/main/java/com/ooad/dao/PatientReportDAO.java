package com.ooad.dao;


import com.ooad.model.PatientDate;
import com.ooad.model.PatientReport;

import java.util.List;

public interface PatientReportDAO {
    PatientReport findById(PatientDate patientDate);

    void save(PatientReport patientReport);

    void update(PatientReport patientReport);

    void delete(PatientDate patientDate);

    List<PatientReport> findAllReportsForId(int id);
}
