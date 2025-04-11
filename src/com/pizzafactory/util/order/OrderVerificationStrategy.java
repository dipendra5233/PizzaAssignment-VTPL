package com.pizzafactory.util.order;

import com.pizzafactory.model.Inventory;
import com.pizzafactory.model.Order;

/*
 * OrderVerificationStrategy interface defines the contract for verifying orders.
 * Implementations of this interface can provide different strategies for order verification.
 */
public interface OrderVerificationStrategy {
    boolean verifyOrder(Order order, Inventory inventory);
}