package com.pizzafactory.model;
/**
 * Represents a side item in the pizza factory.
 */
public class Side {
    private final String name;
    private final double price;

    public Side(String name, double price) {
        // Validate the name and price fields.
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Side name cannot be null or empty");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}