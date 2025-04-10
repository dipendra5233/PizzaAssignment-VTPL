package com.pizzafactory.util;

import com.pizzafactory.model.*;
/**
 * This class implements a business rule that checks if a large pizza has more than 2 free toppings.
 * If it does, the rule will return false and print a message indicating the violation.
 */
public class LargePizzaFreeToppingsRule implements BusinessRule {
    // Maximum number of free toppings allowed for a large pizza.
    private static final int MAX_FREE_TOPPINGS = 2;

    @Override
    public boolean verify(Order order, Inventory inventory) {
        for (Pizza pizza : order.getPizzas()) {
            if ("Large".equalsIgnoreCase(pizza.getSize())) {
                if (pizza.getToppings().size() > MAX_FREE_TOPPINGS) {
                    System.out.println("Large pizza can have only " + MAX_FREE_TOPPINGS + " free toppings: " + pizza.getName());
                    return false;
                }
            }
        }
        return true;
    }
}