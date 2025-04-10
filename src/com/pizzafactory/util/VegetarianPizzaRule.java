package com.pizzafactory.util;

import com.pizzafactory.model.*;

public class VegetarianPizzaRule implements BusinessRule {
    @Override
    public boolean verify(Order order, Inventory inventory) {
        for (Pizza pizza : order.getPizzas()) {
            if (pizza.getType().equalsIgnoreCase("Veg")) {
                for (Topping topping : pizza.getToppings()) {
                    if (!topping.getType().toString().equalsIgnoreCase("Veg")) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}