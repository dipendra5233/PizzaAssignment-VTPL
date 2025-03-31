package com.pizzafactory.model;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private String size;
    private String type;
    private Crust crust;
    private List<Topping> toppings;
    private double price;

    public Pizza(String name, String size, String type, Crust crust, double price) {
        this.name = name;
        this.size = size;
        this.type = type;
        this.crust = crust;
        this.price = price;
        this.toppings = new ArrayList<>();
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public double getPrice() {
        return price;
    }

    // Getters and setters
    // ...
}