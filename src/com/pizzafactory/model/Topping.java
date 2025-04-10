package com.pizzafactory.model;
/**
 * Represents a topping for a pizza.
 */
public class Topping {
    // Represents the type of toppings.
    public enum Type {
        VEG, NON_VEG
    }

    private final String name;
    private final double price;
    private final Type type;

    public Topping(String name, double price, Type type) {
        // Validate the name, price, and type fields.
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Topping name cannot be null or empty");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Type getType() {
        return type;
    }

    public boolean isNonVeg() {
        return type == Type.NON_VEG;
    }
}