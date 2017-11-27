package com.ooad.dao;

import com.ooad.model.Admin;
import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("adminDao")
public class AdminDAOImpl extends AbstractDAO<Integer, Admin> implements AdminDAO {

    public Admin findById(int id) {
        return getByKey(id);
    }

    public Admin findByUserName(String username) {
        List<Admin> allAdmins = findAllAdmins();
        System.out.println(allAdmins);
        for(Admin admin: allAdmins){
            if(admin.getUsername().equals(username)){
                return admin;
            }
        }
        return null;
    }

    public Admin save(Admin admin) {
        persist(admin);
        return admin;
    }

    public void delete(int id) {
        Query query = getSession().createSQLQuery("delete from User where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    public List<Admin> findAllAdmins() {
        Criteria criteria = createEntityCriteria();
        return (List<Admin>) criteria.list();
    }

    public List<Admin> findAdmins(String searchTerm) {
        String regex = searchTerm.toLowerCase();
        List<Admin> allAdmins = findAllAdmins();
        List<Admin> admins = new ArrayList<Admin>();
        System.out.println(allAdmins);
        for (Admin admin : allAdmins) {
            if (admin.getFirstName().toLowerCase().contains(regex) || admin.getLastName().toLowerCase().contains(regex)) {
                admins.add(admin);
            }
        }
        return admins;
    }
}
