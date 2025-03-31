package com.pizzafactory.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Customer customer;
    private List<Pizza> pizzas;
    private List<Side> sides;
    private double totalAmount;

    public Order(Customer customer) {
        this.customer = customer;
        this.pizzas = new ArrayList<>();
        this.sides = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
        totalAmount += pizza.getPrice();
    }

    public void addSide(Side side) {
        sides.add(side);
        totalAmount += side.getPrice();
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    // Getters and setters
    // ...
}