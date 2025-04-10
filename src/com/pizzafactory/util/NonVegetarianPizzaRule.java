package com.pizzafactory.util;

import com.pizzafactory.model.*;

public class NonVegetarianPizzaRule implements BusinessRule {
    @Override
    public boolean verify(Order order, Inventory inventory) {
        for (Pizza pizza : order.getPizzas()) {
            if (pizza.getType().equalsIgnoreCase("Non-Veg")) {
                for (Topping topping : pizza.getToppings()) {
                    if (topping.getName().equalsIgnoreCase("Paneer")) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}