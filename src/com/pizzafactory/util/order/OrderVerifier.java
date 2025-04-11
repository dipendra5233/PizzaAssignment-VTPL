package com.pizzafactory.util.order;

import com.pizzafactory.model.*;
import com.pizzafactory.service.InventoryService;

/**
 * OrderVerifier class is responsible for verifying orders based on the provided strategy.
 * It uses the InventoryService to get the current inventory status.
 */
public class OrderVerifier {
    private final OrderVerificationStrategy orderVerificationStrategy;
    private final InventoryService inventoryService;

    public OrderVerifier(OrderVerificationStrategy orderVerificationStrategy, InventoryService inventoryService) {
        this.orderVerificationStrategy = orderVerificationStrategy;
        this.inventoryService = inventoryService;
    }

    public boolean verifyOrder(Order order) {
        return orderVerificationStrategy.verifyOrder(order, inventoryService.getInventory());
    }
}