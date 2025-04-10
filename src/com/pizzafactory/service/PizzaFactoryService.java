package com.pizzafactory.service;

import com.pizzafactory.util.OrderVerificationStrategy;
/**
 * PizzaFactoryService class is responsible for managing the services related to the pizza factory.
 * It provides access to the MenuService, InventoryService, and OrderService.
 * It Acts as a facade to coordinate the services.
 */
public class PizzaFactoryService {
    private final MenuService menuService;
    private final InventoryService inventoryService;
    private final OrderService orderService;

    public PizzaFactoryService(MenuService menuService, InventoryService inventoryService, OrderService orderService) {
        this.menuService = menuService;
        this.inventoryService = inventoryService;
        this.orderService = orderService;
    }

    public MenuService getMenuService() {
        return menuService;
    }

    public InventoryService getInventoryService() {
        return inventoryService;
    }

    public OrderService getOrderService() {
        return orderService;
    }
}