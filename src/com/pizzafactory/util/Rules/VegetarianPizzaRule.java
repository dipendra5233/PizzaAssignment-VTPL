package com.pizzafactory.util.Rules;

import com.pizzafactory.model.*;
import com.pizzafactory.util.BusinessRule;
/**
 * This class implements a business rule that checks if all toppings of a vegetarian pizza are vegetarian.
 * If any topping is non-vegetarian, the rule will return false.
 */
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