package com.ooad.dao;

import com.ooad.model.Patient;
import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("patientDao")
public class PatientDAOImpl extends AbstractDAO<Integer, Patient> implements PatientDAO {


    public Patient findById(int id) {
        return getByKey(id);
    }

    public Patient findByUserName(String username) {
        List<Patient> allPatients = findAllPatients();
        System.out.println(allPatients);
        for (Patient patient : allPatients) {
            if (patient.getUsername().equals(username)) {
                return patient;
            }
        }
        return null;
    }

    public void save(Patient patient) {
        persist(patient);
    }

    public void update(Patient patient) {
        getSession().update(patient);
    }

    public void delete(int id) {
        Query query = getSession().createSQLQuery("delete from User where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    public List<Patient> findAllPatients() {
        Criteria criteria = createEntityCriteria();
        return (List<Patient>) criteria.list();
    }

    public List<Patient> findPatients(String searchTerm) {
        String regex = searchTerm.toLowerCase();
        List<Patient> allPatients = findAllPatients();
        List<Patient> patients = new ArrayList<Patient>();
        System.out.println(allPatients);
        for (Patient patient : allPatients) {
            if (patient.getFirstName().toLowerCase().contains(regex) || patient.getLastName().toLowerCase().contains(regex)) {
                patients.add(patient);
            }
        }
        return patients;
    }
}
