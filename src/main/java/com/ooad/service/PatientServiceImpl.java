package com.ooad.service;

import com.ooad.dao.PatientDAO;
import com.ooad.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("patientService")
@Transactional
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientDAO dao;

    public Patient findById(int id) {
        return dao.findById(id);
    }

    public Patient findByUserName(String username) {
        return dao.findByUserName(username);
    }

    public void savePatient(Patient patient) {
        dao.save(patient);
    }

    public void updatePatient(Patient patient) {
        Patient entity = dao.findById(patient.getId());
        System.out.println(entity);
        if (entity != null) {
            entity.setFirstName(patient.getFirstName());
            entity.setLastName(patient.getLastName());
            entity.setAge(patient.getAge());
            entity.setPhone(patient.getPhone());
            entity.setGender(patient.getGender());
            entity.setAddress(patient.getAddress());
            entity.setEmailId(patient.getEmailId());
        }
    }

    public void deletePatient(int id) {
        dao.delete(id);
    }

    public List<Patient> findAllPatients() {
        return dao.findAllPatients();
    }

    public List<Patient> findPatients(String searchTerm) {
        return dao.findPatients(searchTerm);
    }
}
