package com.pizzafactory.model;

import java.util.ArrayList;
import java.util.List;
/**
 * Order class represents a customer's order in the pizza factory.
 * It contains a list of pizzas and sides ordered by the customer.
 */
public class Order {
    private Customer customer;
    final private List<Pizza> pizzas = new ArrayList<>();
    final private List<Side> sides = new ArrayList<>();

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
}