package com.pizzafactory.model;
/**
 * Represents a crust type for a pizza.
 */
public class Crust {
    // The name of the crust
    private final String name;

    public Crust(String name) {
        // Validate the name field
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Crust name cannot be null or empty");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}