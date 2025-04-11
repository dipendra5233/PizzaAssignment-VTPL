package com.pizzafactory.util.Rules;

import com.pizzafactory.model.*;
import com.pizzafactory.util.BusinessRule;

/**
 * This class implements a business rule that ensures that each pizza in an order has at most one non-veg topping.
 */
public class SingleNonVegToppingPerPizzaRule implements BusinessRule {
    @Override
    public boolean verify(Order order, Inventory inventory) {
        for (Pizza pizza : order.getPizzas()) {
            if (pizza.getType().equalsIgnoreCase("Non-Veg")) {
                int nonVegToppingCount = 0;
                for (Topping topping : pizza.getToppings()) {
                    if (!topping.getType().toString().equalsIgnoreCase("Veg")) {
                        nonVegToppingCount++;
                    }
                }
                if (nonVegToppingCount > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}