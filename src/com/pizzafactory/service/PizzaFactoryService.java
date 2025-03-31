package com.pizzafactory.service;

import com.pizzafactory.model.*;
import com.pizzafactory.util.BusinessRules;

import java.util.ArrayList;
import java.util.List;

public class PizzaFactoryService {
    private List<Pizza> pizzas = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();
    private List<Topping> toppings = new ArrayList<>();
    private List<Side> sides = new ArrayList<>();
    private List<Crust> crusts = new ArrayList<>();
    private Inventory inventory = new Inventory();

    public synchronized void initializeMenu() {
        pizzas.clear();
        categories.clear();
        toppings.clear();
        sides.clear();
        crusts.clear();
    }

    public synchronized void addPizzaToMenu(Pizza pizza) {
        pizzas.add(pizza);
    }

    public synchronized void addCategoryToMenu(Category category) {
        categories.add(category);
    }

    public synchronized void addToppingToMenu(Topping topping) {
        toppings.add(topping);
    }

    public synchronized void addSideToMenu(Side side) {
        sides.add(side);
    }

    public synchronized void addCrustToMenu(Crust crust) {
        crusts.add(crust);
    }

    public synchronized boolean placeOrder(Order order) {
        if (!BusinessRules.verifyOrder(order, inventory)) {
            return false;
        }
        // Deduct inventory
        for (Pizza pizza : order.getPizzas()) {
            inventory.deduct(pizza.getName(), 1);
            for (Topping topping : pizza.getToppings()) {
                inventory.deduct(topping.getName(), 1);
            }
        }
        for (Side side : order.getSides()) {
            inventory.deduct(side.getName(), 1);
        }
        return true;
    }

    public synchronized void restockInventory(String item, int quantity) {
        inventory.restock(item, quantity);
    }

    public synchronized Inventory getInventory() {
        return inventory;
    }

    public synchronized void changePrice(String pizzaName, double newPrice) {
        for (Pizza pizza : pizzas) {
            if (pizza.getName().equals(pizzaName)) {
                pizza.setPrice(newPrice);
                break;
            }
        }
    }
}