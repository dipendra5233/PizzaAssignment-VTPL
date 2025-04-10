package com.pizzafactory.util;

import com.pizzafactory.model.*;

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