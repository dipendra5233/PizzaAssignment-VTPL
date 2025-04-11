package com.pizzafactory.util.Rules;

import com.pizzafactory.model.*;
import com.pizzafactory.util.BusinessRule;
/**
 * This class implements a business rule that checks if each pizza in an order has a crust.
 * If any pizza does not have a crust, the rule will return false.
 */
public class SingleCrustPerPizzaRule implements BusinessRule {
    @Override
    public boolean verify(Order order, Inventory inventory) {
        for (Pizza pizza : order.getPizzas()) {
            if (pizza.getCrust() == null) {
                return false;
            }
        }
        return true;
    }
}