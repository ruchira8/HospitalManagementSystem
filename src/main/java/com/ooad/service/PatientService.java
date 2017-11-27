package com.ooad.service;


import com.ooad.model.Patient;

import java.util.List;

public interface PatientService {
    Patient findById(int id);

    Patient findByUserName(String username);

    void savePatient(Patient patient);

    void updatePatient(Patient patient);

    void deletePatient(int id);

    List<Patient> findAllPatients();

    List<Patient> findPatients(String searchTerm);
}
