package com.pizzafactory.model;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Pizza> pizzas;
    private List<Topping> toppings;
    private List<Side> sides;
    private List<Crust> crusts;

    public Menu() {
        this.pizzas = new ArrayList<>();
        this.toppings = new ArrayList<>();
        this.sides = new ArrayList<>();
        this.crusts = new ArrayList<>();
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public void addSide(Side side) {
        sides.add(side);
    }

    public void addCrust(Crust crust) {
        crusts.add(crust);
    }

    // Getters for pizzas, toppings, sides, and crusts
    // ...
}