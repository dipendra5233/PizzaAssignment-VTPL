package com.pizzafactory.model;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Integer> items;

    public Inventory() {
        this.items = new HashMap<>();
    }

    public void addItem(String item, int quantity) {
        items.put(item, items.getOrDefault(item, 0) + quantity);
    }

    public boolean isAvailable(String item, int quantity) {
        return items.getOrDefault(item, 0) >= quantity;
    }

    public void useItem(String item, int quantity) {
        if (isAvailable(item, quantity)) {
            items.put(item, items.get(item) - quantity);
        }
    }

    public void updateInventory(Order order) {
        // Update inventory based on the placed order
        // ...
    }

    // Other inventory management methods
    // ...
}