package com.ooad.service;

import com.ooad.dao.InventoryItemDAO;
import com.ooad.model.InventoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("inventoryService")
@Transactional
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryItemDAO inventoryItemDAO;

    public InventoryItem findById(int id) {
        return inventoryItemDAO.findById(id);
    }

    public InventoryItem save(InventoryItem inventoryItem) {
        return inventoryItemDAO.save(inventoryItem);
    }

    public void delete(int id) {
        inventoryItemDAO.delete(id);
    }

    public void update(InventoryItem inventoryItem) {
        InventoryItem entity = inventoryItemDAO.findById(inventoryItem.getId());
        if (entity != null) {
            entity.setName(inventoryItem.getName());
            entity.setAvailable(inventoryItem.getAvailable());
            entity.setType(inventoryItem.getType());
        }
    }

    public List<InventoryItem> findAllInventoryItems() {
        return inventoryItemDAO.findAllInventoryItems();
    }

    public List<InventoryItem> findItemsToOrder() {
        return inventoryItemDAO.findItemsToOrder();
    }

    public List<InventoryItem> findItems(String searchTerm) {
        return inventoryItemDAO.findItems(searchTerm);
    }
}
