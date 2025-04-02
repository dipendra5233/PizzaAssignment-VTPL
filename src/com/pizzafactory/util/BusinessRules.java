package com.pizzafactory.util;

import com.pizzafactory.model.*;

public class BusinessRules {
    public static boolean verifyOrder(Order order, Inventory inventory) {
        for (Pizza pizza : order.getPizzas()) {
            if (!inventory.isAvailable(pizza.getName(), 1)) {
                System.out.println("Pizza not available: " + pizza.getName());
                return false;
            }
            if (pizza.getCrust() == null) {
                System.out.println("Pizza must have a crust: " + pizza.getName());
                return false;
            }
            int nonVegToppingCount = 0;
            for (Topping topping : pizza.getToppings()) {
                if (!inventory.isAvailable(topping.getName(), 1)) {
                    System.out.println("Topping not available: " + topping.getName());
                    return false;
                }
                if (pizza.getType().equals("Vegetarian") && topping.isNonVeg()) {
                    System.out.println("Vegetarian pizza cannot have non-veg topping: " + topping.getName());
                    return false;
                }
                if (pizza.getType().equals("Non-Vegetarian") && topping.getName().equals("Paneer")) {
                    System.out.println("Non-vegetarian pizza cannot have paneer topping: " + topping.getName());
                    return false;
                }
                if (pizza.getType().equals("Non-Vegetarian") && topping.isNonVeg()) {
                    nonVegToppingCount++;
                    if (nonVegToppingCount > 1) {
                        System.out.println("Non-vegetarian pizza can have only one non-veg topping: " + topping.getName());
                        return false;
                    }
                }
            }
            if (pizza.getSize().equals("Large") && pizza.getToppings().size() > 2) {
                System.out.println("Large size pizzas can have only 2 toppings with no additional cost: " + pizza.getName());
                return false;
            }
        }
        for (Side side : order.getSides()) {
            if (!inventory.isAvailable(side.getName(), 1)) {
                System.out.println("Side not available: " + side.getName());
                return false;
            }
        }
        return true;
    }
}