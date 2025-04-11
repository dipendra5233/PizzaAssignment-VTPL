package com.pizzafactory.util;

import com.pizzafactory.model.Inventory;
import com.pizzafactory.model.Order;
/**
 * BusinessRule interface defines a contract for business rules in the pizza factory.
 * It contains a method to verify an order against the inventory.
 */
public interface BusinessRule {
    boolean verify(Order order, Inventory inventory);
}
