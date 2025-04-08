package com.pizzafactory.util;

import com.pizzafactory.model.Order;
import com.pizzafactory.model.Inventory;

import java.util.ArrayList;
import java.util.List;

public class BusinessRules {
    private List<BusinessRule> rules;

    public BusinessRules() {
        rules = new ArrayList<>();
        // Add default rules
        rules.add(new VegetarianPizzaRule());
        rules.add(new NonVegetarianPizzaRule());
        rules.add(new SingleCrustPerPizzaRule());
        rules.add(new SingleNonVegToppingPerPizzaRule());
        rules.add(new LargePizzaFreeToppingsRule());
    }

    public void addRule(BusinessRule rule) {
        rules.add(rule);
    }

    public boolean verifyOrder(Order order, Inventory inventory) {
        for (BusinessRule rule : rules) {
            if (!rule.verify(order, inventory)) {
                return false;
            }
        }
        return true;
    }
}