package com.pizzafactory.service;

import com.pizzafactory.model.*;
import com.pizzafactory.util.BusinessRules;

import java.util.ArrayList;
import java.util.List;

public class PizzaFactoryService {
    private Menu menu;
    private Inventory inventory;
    private List<Order> orders;

    public PizzaFactoryService() {
        this.menu = new Menu();
        this.inventory = new Inventory();
        this.orders = new ArrayList<>();
    }

    public void addPizzaToMenu(Pizza pizza) {
        menu.addPizza(pizza);
    }

    public void addToppingToMenu(Topping topping) {
        menu.addTopping(topping);
    }

    public void addSideToMenu(Side side) {
        menu.addSide(side);
    }

    public void addCrustToMenu(Crust crust) {
        menu.addCrust(crust);
    }

    public boolean placeOrder(Order order) {
        if (BusinessRules.verifyOrder(order, inventory)) {
            orders.add(order);
            inventory.updateInventory(order);
            return true;
        }
        return false;
    }

    // Other methods to manage inventory, orders, etc.
}