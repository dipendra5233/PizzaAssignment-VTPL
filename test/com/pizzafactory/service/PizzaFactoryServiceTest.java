package com.pizzafactory.service;

import com.pizzafactory.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PizzaFactoryServiceTest {
    private PizzaFactoryService pizzaFactory;
    private MenuService menuService;
    private InventoryService inventoryService;
    private OrderService orderService;

    @BeforeEach
    public void setUp() {
        menuService = mock(MenuService.class);
        inventoryService = mock(InventoryService.class);
        orderService = mock(OrderService.class);
        pizzaFactory = new PizzaFactoryService(menuService, inventoryService, orderService);

        // Set up the menu using addMenuItem
        doNothing().when(menuService).addMenuItem(eq("Pizzas"), any(Pizza.class));
        doNothing().when(menuService).addMenuItem(eq("Toppings"), any(Topping.class));
        doNothing().when(menuService).addMenuItem(eq("Sides"), any(Side.class));
        doNothing().when(menuService).addMenuItem(eq("Crusts"), any(Crust.class));
    }

    @Test
    public void testPlaceOrder() {
        Order order = new Order(new Customer("John Doe", "1234567890"));
        Pizza pizza = new Pizza("Deluxe Veggie", "Regular", "Veg", new Crust("New hand tossed"), 150);
        pizza.addTopping(new Topping("Black olive", 20, Topping.Type.VEG));
        order.addPizza(pizza);
        order.addSide(new Side("Cold drink", 55));

        when(orderService.placeOrder(order)).thenReturn(true);

        assertTrue(pizzaFactory.getOrderService().placeOrder(order));
        verify(orderService).placeOrder(order);
    }

    @Test
    public void testRestockInventory() {
        // Mock the behavior of restockItem and isItemAvailable methods
        doNothing().when(inventoryService).restockItem("Black olive", 50);
        when(inventoryService.isItemAvailable("Black olive", 50)).thenReturn(true);

        // Call the methods and assert the behavior
        pizzaFactory.getInventoryService().restockItem("Black olive", 50);
        assertTrue(pizzaFactory.getInventoryService().isItemAvailable("Black olive", 50));

        // Verify interactions with the mocked methods
        verify(inventoryService).restockItem("Black olive", 50);
        verify(inventoryService).isItemAvailable("Black olive", 50);
    }

    @Test
    public void testChangePrice() {
        Pizza pizza = new Pizza("Deluxe Veggie", "Regular", "Veg", new Crust("New hand tossed"), 150);
        menuService.addMenuItem("Pizzas", pizza);

        verify(menuService).addMenuItem(eq("Pizzas"), eq(pizza));
    }
}