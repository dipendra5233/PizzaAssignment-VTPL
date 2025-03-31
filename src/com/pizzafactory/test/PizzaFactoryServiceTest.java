package com.pizzafactory.test;

import com.pizzafactory.model.*;
import com.pizzafactory.service.PizzaFactoryService;
import com.pizzafactory.util.BusinessRules;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PizzaFactoryServiceTest {
    private PizzaFactoryService pizzaFactory;

    @BeforeEach
    public void setUp() {
        pizzaFactory = new PizzaFactoryService();

        // Set up the menu
        pizzaFactory.addPizzaToMenu(new Pizza("Deluxe Veggie", "Regular", "Vegetarian", new Crust("New hand tossed"), 150));
        pizzaFactory.addPizzaToMenu(new Pizza("Chicken Tikka", "Medium", "Non-Vegetarian", new Crust("Cheese Burst"), 370));

        // Add toppings to menu
        pizzaFactory.addToppingToMenu(new Topping("Black olive", 20));
        pizzaFactory.addToppingToMenu(new Topping("Chicken tikka", 35));
        pizzaFactory.addToppingToMenu(new Topping("Paneer", 35));

        // Add sides to menu
        pizzaFactory.addSideToMenu(new Side("Cold drink", 55));
        pizzaFactory.addSideToMenu(new Side("Mousse cake", 90));

        // Add crusts to menu
        pizzaFactory.addCrustToMenu(new Crust("New hand tossed"));
        pizzaFactory.addCrustToMenu(new Crust("Cheese Burst"));
    }

    @Test
    public void testPlaceOrder() {
        Customer customer = new Customer("John Doe", "1234567890");
        Order order = new Order(customer);
        Pizza pizza = new Pizza("Deluxe Veggie", "Regular", "Vegetarian", new Crust("New hand tossed"), 150);
        pizza.addTopping(new Topping("Black olive", 20));
        order.addPizza(pizza);
        order.addSide(new Side("Cold drink", 55));

        assertTrue(pizzaFactory.placeOrder(order));
    }

    @Test
    public void testRestockInventory() {
        pizzaFactory.restockInventory("Black olive", 50);
        assertTrue(pizzaFactory.getInventory().isAvailable("Black olive", 50));
    }

    @Test
    public void testChangePrice() {
        Pizza pizza = new Pizza("Deluxe Veggie", "Regular", "Vegetarian", new Crust("New hand tossed"), 150);
        pizzaFactory.addPizzaToMenu(pizza);
        pizzaFactory.changePrice("Deluxe Veggie", 200);
        assertEquals(200, pizza.getPrice());
    }

    @Test
    public void testVegetarianPizzaWithNonVegetarianTopping() {
        Customer customer = new Customer("Jane Doe", "0987654321");
        Order order = new Order(customer);
        Pizza pizza = new Pizza("Deluxe Veggie", "Regular", "Vegetarian", new Crust("New hand tossed"), 150);
        pizza.addTopping(new Topping("Chicken tikka", 35));
        order.addPizza(pizza);

        assertFalse(BusinessRules.verifyOrder(order, pizzaFactory.getInventory()));
    }

    @Test
    public void testNonVegetarianPizzaWithPaneerTopping() {
        Customer customer = new Customer("Jane Doe", "0987654321");
        Order order = new Order(customer);
        Pizza pizza = new Pizza("Chicken Tikka", "Medium", "Non-Vegetarian", new Crust("Cheese Burst"), 370);
        pizza.addTopping(new Topping("Paneer", 35));
        order.addPizza(pizza);

        assertFalse(BusinessRules.verifyOrder(order, pizzaFactory.getInventory()));
    }

    @Test
    public void testSingleCrustPerPizza() {
        Pizza pizza = new Pizza("Deluxe Veggie", "Regular", "Vegetarian", new Crust("New hand tossed"), 150);
        pizza.setCrust(new Crust("Cheese Burst"));
        assertEquals("Cheese Burst", pizza.getCrust().getName());
    }

    @Test
    public void testSingleNonVegToppingPerPizza() {
        Customer customer = new Customer("Jane Doe", "0987654321");
        Order order = new Order(customer);
        Pizza pizza = new Pizza("Chicken Tikka", "Medium", "Non-Vegetarian", new Crust("Cheese Burst"), 370);
        pizza.addTopping(new Topping("Chicken tikka", 35));
        pizza.addTopping(new Topping("Barbeque chicken", 45));
        order.addPizza(pizza);

        assertFalse(BusinessRules.verifyOrder(order, pizzaFactory.getInventory()));
    }

    @Test
    public void testLargePizzaWithTwoFreeToppings() {
        Customer customer = new Customer("Jane Doe", "0987654321");
        Order order = new Order(customer);
        Pizza pizza = new Pizza("Deluxe Veggie", "Large", "Vegetarian", new Crust("New hand tossed"), 325);
        pizza.addTopping(new Topping("Black olive", 20));
        pizza.addTopping(new Topping("Paneer", 35));
        order.addPizza(pizza);

        assertTrue(BusinessRules.verifyOrder(order, pizzaFactory.getInventory()));
        assertEquals(325, pizza.getPrice());
    }

    @Test
    public void testMultiplePizzasInOrder() {
        Customer customer = new Customer("Alice", "9876543210");
        Order order = new Order(customer);
        Pizza pizza1 = new Pizza("Deluxe Veggie", "Regular", "Vegetarian", new Crust("New hand tossed"), 150);
        pizza1.addTopping(new Topping("Black olive", 20));
        Pizza pizza2 = new Pizza("Chicken Tikka", "Medium", "Non-Vegetarian", new Crust("Cheese Burst"), 370);
        pizza2.addTopping(new Topping("Chicken tikka", 35));
        order.addPizza(pizza1);
        order.addPizza(pizza2);

        assertTrue(pizzaFactory.placeOrder(order));
        assertEquals(2, order.getPizzas().size());
    }

    @Test
    public void testSelectCrustAndAddToppings() {
        Pizza pizza = new Pizza("Paneer Tikka", "Large", "Vegetarian", new Crust("Fresh pan pizza"), 340);
        pizza.addTopping(new Topping("Capsicum", 25));
        pizza.addTopping(new Topping("Mushroom", 30));

        assertEquals("Fresh pan pizza", pizza.getCrust().getName());
        assertEquals(2, pizza.getToppings().size());
    }

    @Test
    public void testVerifyOrderAmount() {
        Customer customer = new Customer("Bob", "1122334455");
        Order order = new Order(customer);
        Pizza pizza = new Pizza("Cheese and corn", "Medium", "Vegetarian", new Crust("Wheat thin crust"), 375);
        pizza.addTopping(new Topping("Paneer", 35));
        order.addPizza(pizza);
        order.addSide(new Side("Mousse cake", 90));

        double expectedAmount = 375 + 35 + 90;
        assertEquals(expectedAmount, order.getTotalAmount());
    }

    @Test
    public void testAddSideOrder() {
        Customer customer = new Customer("Charlie", "5544332211");
        Order order = new Order(customer);
        Pizza pizza = new Pizza("Non-Veg Supreme", "Large", "Non-Vegetarian", new Crust("New hand tossed"), 425);
        order.addPizza(pizza);
        order.addSide(new Side("Cold drink", 55));

        assertTrue(pizzaFactory.placeOrder(order));
        assertEquals(1, order.getSides().size());
    }
}