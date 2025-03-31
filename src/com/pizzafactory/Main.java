package com.pizzafactory;

import com.pizzafactory.model.*;
import com.pizzafactory.service.PizzaFactoryService;

public class Main {
    public static void main(String[] args) {
        PizzaFactoryService pizzaFactory = new PizzaFactoryService();

        // Add pizzas to menu
        pizzaFactory.addPizzaToMenu(new Pizza("Deluxe Veggie", "Regular", "Vegetarian", new Crust("New hand tossed"), 150));
        pizzaFactory.addPizzaToMenu(new Pizza("Chicken Tikka", "Medium", "Non-Vegetarian", new Crust("Cheese Burst"), 370));

        // Add toppings to menu
        pizzaFactory.addToppingToMenu(new Topping("Black olive", 20));
        pizzaFactory.addToppingToMenu(new Topping("Chicken tikka", 35));

        // Add sides to menu
        pizzaFactory.addSideToMenu(new Side("Cold drink", 55));
        pizzaFactory.addSideToMenu(new Side("Mousse cake", 90));

        // Add crusts to menu
        pizzaFactory.addCrustToMenu(new Crust("New hand tossed"));
        pizzaFactory.addCrustToMenu(new Crust("Cheese Burst"));

        // Create a customer
        Customer customer = new Customer("John Doe", "1234567890");

        // Create an order
        Order order = new Order(customer);
        Pizza pizza = new Pizza("Deluxe Veggie", "Regular", "Vegetarian", new Crust("New hand tossed"), 150);
        pizza.addTopping(new Topping("Black olive", 20));
        order.addPizza(pizza);
        order.addSide(new Side("Cold drink", 55));

        // Place the order
        if (pizzaFactory.placeOrder(order)) {
            System.out.println("Order placed successfully!");
        } else {
            System.out.println("Order could not be placed.");
        }
    }
}