package com.ooad.dao;

import com.ooad.model.Patient;
import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("patientDao")
public class PatientDAOImpl extends AbstractDAO<Integer, Patient> implements PatientDAO {


    public Patient findById(int id) {
        return getByKey(id);
    }

    public void save(Patient patient) {
        persist(patient);
    }

    public void update(Patient patient) {
        getSession().update(patient);
    }

    public void delete(int id) {
        Query query = getSession().createSQLQuery("delete from Patient where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    public List<Patient> findAllPatients() {
        Criteria criteria = createEntityCriteria();
        return (List<Patient>) criteria.list();
    }
}
