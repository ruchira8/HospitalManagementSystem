package com.ooad.dao;

import com.ooad.model.PatientDate;
import com.ooad.model.PatientReport;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("patientReportDao")
public class PatientReportDAOImpl extends AbstractDAO<Integer, PatientReport> implements PatientReportDAO {

    public PatientReport findById(PatientDate patientDate) {
        Criteria criteria = createEntityCriteria();
        Criterion criterion = Restrictions.conjunction()
                .add(Restrictions.eq("patientDate.id", patientDate.getId()))
                .add(Restrictions.eq("patientDate.date", patientDate.getDate()));
        List<PatientReport> patientReports = (List<PatientReport>) criteria.add(criterion).list();
        if (!patientReports.isEmpty()) {
            return patientReports.get(0);
        }
        return null;
    }

    public void save(PatientReport patientReport) {
        persist(patientReport);
    }

    public void update(PatientReport patientReport) {
        getSession().update(patientReport);
    }

    public void delete(PatientDate patientDate) {
        Query query = getSession().createSQLQuery("delete from Patient_Report where id = :id and date = :date");
        query.setInteger("id", patientDate.getId());
        query.setParameter("date", patientDate.getDate());
        query.executeUpdate();
    }

    public List<PatientReport> findAllReportsForId(int id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("patientDate.id", id));
        return (List<PatientReport>) criteria.list();
    }
}
