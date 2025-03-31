package com.pizzafactory.model;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private String size;
    private String type;
    private Crust crust;
    private double price;
    private List<Topping> toppings = new ArrayList<>();

    public Pizza(String name, String size, String type, Crust crust, double price) {
        this.name = name;
        this.size = size;
        this.type = type;
        this.crust = crust;
        this.price = price;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setCrust(Crust crust) {
        this.crust = crust;
    }

    public Crust getCrust() {
        return crust;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setName(String name) {
        this.name = name;
    }

}