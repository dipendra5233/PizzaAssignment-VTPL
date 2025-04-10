package com.pizzafactory.service;

import com.pizzafactory.model.*;
/**
 * OrderService is responsible for managing orders in the pizza factory.
 * It handles order placement, inventory deduction, and order verification.
 */
public class OrderService {
    private final InventoryService inventoryService;
    private final OrderVerifier orderVerifier;

    public OrderService(InventoryService inventoryService, OrderVerifier orderVerifier) {
        this.inventoryService = inventoryService;
        this.orderVerifier = orderVerifier;
    }

    public synchronized boolean placeOrder(Order order) {
        if (!orderVerifier.verifyOrder(order)) {
            System.out.println("Order verification failed.");
            return false;
        }
        deductInventory(order);
        return true;
    }

    private void deductInventory(Order order) {
        for (Pizza pizza : order.getPizzas()) {
            inventoryService.deductItem(pizza.getName(), 1);
            for (Topping topping : pizza.getToppings()) {
                inventoryService.deductItem(topping.getName(), 1);
            }
        }
        for (Side side : order.getSides()) {
            inventoryService.deductItem(side.getName(), 1);
        }
    }
}