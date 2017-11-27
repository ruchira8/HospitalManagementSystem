package com.ooad.dao;

import com.ooad.model.InventoryItem;
import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("inventoryDAO")
public class InventoryItemDAOImpl extends AbstractDAO<Integer, InventoryItem> implements InventoryItemDAO {
    public InventoryItem findById(int id) {
        return getByKey(id);
    }

    public InventoryItem save(InventoryItem inventoryItem) {
        persist(inventoryItem);
        return inventoryItem;
    }

    public void delete(int id) {
        Query query = getSession().createSQLQuery("delete from Inventory where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    public List<InventoryItem> findAllInventoryItems() {
        Criteria criteria = createEntityCriteria();
        return (List<InventoryItem>) criteria.list();
    }

    public List<InventoryItem> findItemsToOrder() {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("available", 0));
        return (List<InventoryItem>) criteria.list();
    }

    public List<InventoryItem> findItems(String searchTerm) {
        String likeSearchTerm = "%" + searchTerm + "%";
        Criteria criteria = createEntityCriteria();
        Disjunction disjunction = Restrictions.disjunction();
        disjunction.add(Restrictions.like("name", likeSearchTerm).ignoreCase());
        disjunction.add(Restrictions.like("type", likeSearchTerm).ignoreCase());
        criteria.add(disjunction);
        return (List<InventoryItem>) criteria.list();
    }
}
