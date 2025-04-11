package com.pizzafactory.util.order;

import com.pizzafactory.model.Inventory;
import com.pizzafactory.model.Order;
import com.pizzafactory.util.BusinessRules;

public class OrderVerifier {
    private final BusinessRules businessRules;
    private final Inventory inventory;

    public OrderVerifier(BusinessRules businessRules, Inventory inventory) {
        this.businessRules = businessRules;
        this.inventory = inventory;
    }

    public boolean verifyOrder(Order order) {
        return businessRules.verifyOrder(order, inventory);
    }
}