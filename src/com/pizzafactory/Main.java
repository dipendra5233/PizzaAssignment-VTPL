package com.pizzafactory;

import com.pizzafactory.service.InventoryService;
import com.pizzafactory.service.MenuService;
import com.pizzafactory.service.OrderService;
import com.pizzafactory.util.order.OrderVerifier;
import com.pizzafactory.service.PizzaFactoryService;
import com.pizzafactory.util.BusinessRules;
import com.pizzafactory.util.MenuDisplay;
import com.pizzafactory.util.MenuInitializer;
import com.pizzafactory.util.order.OrderHandler;

public class Main {
    public static void main(String[] args) {
        // Initialize services
        MenuService menuService = new MenuService();
        InventoryService inventoryService = new InventoryService();

        // Initialize BusinessRules and OrderVerifier
        BusinessRules businessRules = new BusinessRules();
        OrderVerifier verifier = new OrderVerifier(businessRules, inventoryService.getInventory());

        // Initialize OrderService and PizzaFactoryService
        OrderService orderService = new OrderService(inventoryService, verifier);
        PizzaFactoryService pizzaFactory = new PizzaFactoryService(
                menuService, inventoryService, orderService
        );

        // Initialize menu and inventory
        MenuInitializer.initialize(menuService, inventoryService);

        // Display menu and handle orders
        MenuDisplay.display(menuService);
        OrderHandler.handleOrder(pizzaFactory);
    }
}