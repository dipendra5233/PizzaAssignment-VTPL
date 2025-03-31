package com.pizzafactory.model;

public class Topping {
    private String name;
    private double price;

    public Topping(String name, double price) {
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
}