package com.pizzafactory.model;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Integer> stock = new HashMap<>();

    public synchronized void restock(String item, int quantity) {
        stock.put(item, stock.getOrDefault(item, 0) + quantity);
    }

    public synchronized boolean isAvailable(String item, int quantity) {
        return stock.getOrDefault(item, 0) >= quantity;
    }

    public synchronized void deduct(String item, int quantity) {
        if (isAvailable(item, quantity)) {
            stock.put(item, stock.get(item) - quantity);
        }
    }
}