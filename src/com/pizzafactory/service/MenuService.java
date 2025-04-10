package com.pizzafactory.service;

import com.pizzafactory.model.*;

import java.util.*;

/**
 * MenuService is responsible for managing the menu items in the pizza factory.
 * It allows adding, retrieving, and initializing menu items.
 */
public class MenuService {
    private final Map<String, List<Object>> menuItems = new HashMap<>();

    public MenuService() {
        menuItems.put("Pizzas", new ArrayList<>());
        menuItems.put("Categories", new ArrayList<>());
        menuItems.put("Toppings", new ArrayList<>());
        menuItems.put("Sides", new ArrayList<>());
        menuItems.put("Crusts", new ArrayList<>());
    }

    public synchronized void initializeMenu() {
        menuItems.values().forEach(List::clear);
    }

    public synchronized void addMenuItem(String type, Object item) {
        List<Object> items = menuItems.get(type);
        if (items != null) {
            items.add(item);
        } else {
            throw new IllegalArgumentException("Invalid menu item type: " + type);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> getMenuItems(String type) {
        return (List<T>) menuItems.getOrDefault(type, Collections.emptyList());
    }
}