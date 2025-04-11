package com.pizzafactory.util.Rules;

import com.pizzafactory.model.*;
import com.pizzafactory.util.BusinessRule;
/**
 * This class implements a business rule that checks if a non-vegetarian pizza contains paneer as a topping.
 * If it does, the rule will return false and print a message indicating the violation.
 */
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