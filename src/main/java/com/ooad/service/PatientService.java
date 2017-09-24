package com.ooad.service;


import com.ooad.model.Patient;

import java.util.List;

public interface PatientService {
    Patient findById(int id);

    void savePatient(Patient patient);

    void updatePatient(Patient patient);

    void deletePatient(int id);

    List<Patient> findAllPatients();
}
