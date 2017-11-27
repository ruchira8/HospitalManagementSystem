package com.ooad.service;

import com.ooad.model.InventoryItem;

import java.util.List;

public interface InventoryService {
    InventoryItem findById(int id);

    InventoryItem save(InventoryItem inventoryItem);

    void delete(int id);

    void update(InventoryItem inventoryItem);

    List<InventoryItem> findAllInventoryItems();

    List<InventoryItem> findItemsToOrder();

    List<InventoryItem> findItems(String searchTerm);
}
