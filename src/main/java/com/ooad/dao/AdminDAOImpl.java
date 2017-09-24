package com.ooad.dao;

import com.ooad.model.Admin;
import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("adminDao")
public class AdminDAOImpl extends AbstractDAO<Integer, Admin> implements AdminDAO {

    public Admin findById(int id) {
        return getByKey(id);
    }

    public Admin save(Admin admin) {
        persist(admin);
        return admin;
    }

    public void delete(int id) {
        Query query = getSession().createSQLQuery("delete from Admin where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    public List<Admin> findAllAdmins() {
        Criteria criteria = createEntityCriteria();
        return (List<Admin>) criteria.list();
    }
}
