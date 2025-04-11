package com.pizzafactory;

import com.pizzafactory.service.InventoryService;
import com.pizzafactory.service.MenuService;
import com.pizzafactory.service.OrderService;
import com.pizzafactory.util.order.OrderVerifier;
import com.pizzafactory.service.PizzaFactoryService;
import com.pizzafactory.util.order.DefaultOrderVerificationStrategy;
import com.pizzafactory.util.MenuDisplay;
import com.pizzafactory.util.MenuInitializer;
import com.pizzafactory.util.order.OrderHandler;

public class Main {
    public static void main(String[] args) {
        MenuService menuService = new MenuService();
        InventoryService inventoryService = new InventoryService();
        OrderVerifier verifier = new OrderVerifier(
                new DefaultOrderVerificationStrategy(), inventoryService
        );
        OrderService orderService = new OrderService(inventoryService, verifier);
        PizzaFactoryService pizzaFactory = new PizzaFactoryService(
                menuService, inventoryService, orderService
        );

        MenuInitializer.initialize(menuService, inventoryService);
        MenuDisplay.display(menuService);
        OrderHandler.handleOrder(pizzaFactory);
    }
}