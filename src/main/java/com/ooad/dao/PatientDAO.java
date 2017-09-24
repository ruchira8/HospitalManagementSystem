package com.ooad.dao;

import com.ooad.model.Patient;

import java.util.List;

public interface PatientDAO {

    Patient findById(int id);

    void save(Patient patient);

    void update(Patient patient);

    void delete(int id);

    List<Patient> findAllPatients();

}
