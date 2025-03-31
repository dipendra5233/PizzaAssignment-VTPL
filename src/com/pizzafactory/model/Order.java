package com.pizzafactory.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Customer customer;
    private List<Pizza> pizzas = new ArrayList<>();
    private List<Side> sides = new ArrayList<>();

    public Order(Customer customer) {
        this.customer = customer;
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public void addSide(Side side) {
        sides.add(side);
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public List<Side> getSides() {
        return sides;
    }

    public double getTotalAmount() {
        double total = 0;
        for (Pizza pizza : pizzas) {
            total += pizza.getPrice();
            for (Topping topping : pizza.getToppings()) {
                total += topping.getPrice();
            }
        }
        for (Side side : sides) {
            total += side.getPrice();
        }
        return total;
    }
}