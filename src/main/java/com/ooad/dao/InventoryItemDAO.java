package com.ooad.dao;

import com.ooad.model.InventoryItem;

import java.util.List;

public interface InventoryItemDAO {
    InventoryItem findById(int id);

    InventoryItem save(InventoryItem inventoryItem);

    void delete(int id);

    List<InventoryItem> findAllInventoryItems();

    List<InventoryItem> findItemsToOrder();

    List<InventoryItem> findItems(String searchTerm);
}
