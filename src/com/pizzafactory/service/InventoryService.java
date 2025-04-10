package com.pizzafactory.service;

import com.pizzafactory.model.Inventory;
/** InventoryService is responsible for managing the inventory of items.
 * It provides methods to restock items, check availability, and deduct items from the inventory.
 * Handles inventory-related operations.
 */
public class InventoryService {
    private final Inventory inventory = new Inventory();

    public synchronized void restockItem(String item, int quantity) {
        inventory.restock(item, quantity);
    }

    public synchronized boolean isItemAvailable(String item, int quantity) {
        return inventory.isAvailable(item, quantity);
    }

    public synchronized void deductItem(String item, int quantity) {
        if (!isItemAvailable(item, quantity)) {
            throw new IllegalStateException("Insufficient inventory for item: " + item);
        }
        inventory.deduct(item, quantity);
    }

    // New method to provide access to the Inventory object
    public Inventory getInventory() {
        return inventory;
    }
}