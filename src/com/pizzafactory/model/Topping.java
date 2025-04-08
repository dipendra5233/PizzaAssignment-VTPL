package com.pizzafactory.model;

public class Topping {
    private String name;
    private double price;
    private String type; // Type can be "veg" or "non-veg"

    public Topping(String name, double price, String type) {
        this.name = name;
        this.price = price;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isNonVeg() {
        // Assuming non-veg toppings have specific names
        return name.equals("Chicken tikka") || name.equals("Barbeque chicken") || name.equals("Grilled chicken");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}