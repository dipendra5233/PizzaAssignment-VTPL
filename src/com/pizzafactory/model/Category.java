package com.pizzafactory.model;
/**
 * Represents a category for a pizza or side item.
 */
public class Category {
    private String name;

    public Category(String name) {
        this.name = name;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}