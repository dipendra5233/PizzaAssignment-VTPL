package com.pizzafactory.util;

import com.pizzafactory.model.*;

public class BusinessRules {
    public static boolean verifyOrder(Order order, Inventory inventory) {
        for (Pizza pizza : order.getPizzas()) {
            if (!inventory.isAvailable(pizza.getName(), 1)) {
                return false;
            }
            for (Topping topping : pizza.getToppings()) {
                if (!inventory.isAvailable(topping.getName(), 1)) {
                    return false;
                }
                if (pizza.getType().equals("Vegetarian") && topping.isNonVeg()) {
                    return false;
                }
                if (pizza.getType().equals("Non-Vegetarian") && topping.getName().equals("Paneer")) {
                    return false;
                }
            }
        }
        for (Side side : order.getSides()) {
            if (!inventory.isAvailable(side.getName(), 1)) {
                return false;
            }
        }
        return true;
    }
}