package com.pizzafactory;

import com.pizzafactory.model.*;
import com.pizzafactory.service.PizzaFactoryService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PizzaFactoryService pizzaFactory = new PizzaFactoryService();

        // Initialize the menu
        initializeMenu(pizzaFactory);

        // Display the menu
        displayMenu();

        // Take user input and place order
        placeOrder(pizzaFactory);
    }

    private static void initializeMenu(PizzaFactoryService pizzaFactory) {
        // Add pizzas to menu
        pizzaFactory.addPizzaToMenu(new Pizza("Deluxe Veggie", "Regular", "Vegetarian", new Crust("New hand tossed"), 150));
        pizzaFactory.addPizzaToMenu(new Pizza("Cheese and corn", "Regular", "Vegetarian", new Crust("New hand tossed"), 175));
        pizzaFactory.addPizzaToMenu(new Pizza("Paneer Tikka", "Regular", "Vegetarian", new Crust("New hand tossed"), 160));
        pizzaFactory.addPizzaToMenu(new Pizza("Non-Veg Supreme", "Regular", "Non-Vegetarian", new Crust("New hand tossed"), 190));
        pizzaFactory.addPizzaToMenu(new Pizza("Chicken Tikka", "Regular", "Non-Vegetarian", new Crust("New hand tossed"), 210));
        pizzaFactory.addPizzaToMenu(new Pizza("Pepper Barbecue Chicken", "Regular", "Non-Vegetarian", new Crust("New hand tossed"), 220));

        // Add toppings to menu
        pizzaFactory.addToppingToMenu(new Topping("Black olive", 20, "Veg"));
        pizzaFactory.addToppingToMenu(new Topping("Capsicum", 25,"Veg"));
        pizzaFactory.addToppingToMenu(new Topping("Paneer", 35,"Veg"));
        pizzaFactory.addToppingToMenu(new Topping("Mushroom", 30,"Veg"));
        pizzaFactory.addToppingToMenu(new Topping("Fresh tomato", 10,"Veg"));
        pizzaFactory.addToppingToMenu(new Topping("Chicken tikka", 35,"Non-Veg"));
        pizzaFactory.addToppingToMenu(new Topping("Barbeque chicken", 45,"Non-Veg"));
        pizzaFactory.addToppingToMenu(new Topping("Grilled chicken", 40,"Non-Veg"));
        pizzaFactory.addToppingToMenu(new Topping("Extra cheese", 35,"Veg"));

        // Add sides to menu
        pizzaFactory.addSideToMenu(new Side("Cold drink", 55));
        pizzaFactory.addSideToMenu(new Side("Mousse cake", 90));

        // Add crusts to menu
        pizzaFactory.addCrustToMenu(new Crust("New hand tossed"));
        pizzaFactory.addCrustToMenu(new Crust("Wheat thin crust"));
        pizzaFactory.addCrustToMenu(new Crust("Cheese Burst"));
        pizzaFactory.addCrustToMenu(new Crust("Fresh pan pizza"));

        // Stock inventory
        pizzaFactory.restockInventory("Deluxe Veggie", 10);
        pizzaFactory.restockInventory("Chicken Tikka", 10);
        pizzaFactory.restockInventory("Black olive", 20);
        pizzaFactory.restockInventory("Chicken tikka", 20);
        pizzaFactory.restockInventory("Cold drink", 15);
        pizzaFactory.restockInventory("Mousse cake", 15);

    }

    private static void displayMenu() {
        System.out.println("Vegetarian Pizza:");
        System.out.println("Ø Deluxe Veggie: (Regular: Rs. 150 Medium: Rs. 200 Large: Rs. 325)");
        System.out.println("Ø Cheese and corn: (Regular: Rs. 175 Medium: Rs. 375 Large: Rs. 475)");
        System.out.println("Ø Paneer Tikka: (Regular: Rs. 160 Medium: Rs. 290 Large: Rs. 340)");
        System.out.println("Non-Vegetarian:");
        System.out.println("Ø Non-Veg Supreme: (Regular: Rs 190 Medium: Rs 325 Large: Rs 425)");
        System.out.println("Ø Chicken Tikka: (Regular: Rs 210 Medium: Rs 370 Large: Rs 500)");
        System.out.println("Ø Pepper Barbecue Chicken (Regular: Rs 220 Medium: Rs 380 Large: Rs 525)");
        System.out.println("Type of crust:");
        System.out.println("Ø New hand tossed");
        System.out.println("Ø Wheat thin crust");
        System.out.println("Ø Cheese Burst");
        System.out.println("Ø Fresh pan pizza");
        System.out.println("Extra toppings:");
        System.out.println("Veg toppings:");
        System.out.println("Ø Black olive (Rs 20)");
        System.out.println("Ø Capsicum (Rs 25)");
        System.out.println("Ø Paneer (Rs 35)");
        System.out.println("Ø Mushroom (Rs 30)");
        System.out.println("Ø Fresh tomato (Rs 10)");
        System.out.println("Non-Veg toppings:");
        System.out.println("Ø Chicken tikka (Rs 35)");
        System.out.println("Ø Barbeque chicken (Rs 45)");
        System.out.println("Ø Grilled chicken (Rs 40)");
        System.out.println("Extra cheese: (Rs 35)");
        System.out.println("Sides:");
        System.out.println("Ø Cold drink (Rs 55)");
        System.out.println("Ø Mousse cake (Rs. 90)");
    }

    private static void placeOrder(PizzaFactoryService pizzaFactory) {
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer("John Doe", "1234567890");
        Order order = new Order(customer);

        System.out.println("Enter the name of the pizza you want to order:");
        String pizzaName = scanner.nextLine();
        System.out.println("Enter the size of the pizza (Regular/Medium/Large):");
        String pizzaSize = scanner.nextLine();
        System.out.println("Enter the type of crust:");
        String crustName = scanner.nextLine();

        Pizza pizza = new Pizza(pizzaName, pizzaSize, "Vegetarian", new Crust(crustName), 0); // Price will be set later
        System.out.println("Enter the toppings you want to add (comma separated):");
        String[] toppings = scanner.nextLine().split(",");
        for (String toppingName : toppings) {
            pizza.addTopping(new Topping(toppingName.trim(), 0, "")); // Price will be set later
        }
        order.addPizza(pizza);

        System.out.println("Enter the sides you want to add (comma separated):");
        String[] sides = scanner.nextLine().split(",");
        for (String sideName : sides) {
            order.addSide(new Side(sideName.trim(), 0)); // Price will be set later
        }

        if (pizzaFactory.placeOrder(order)) {
            System.out.println("Order placed successfully!");
        } else {
            System.out.println("Order could not be placed.");
        }
    }
}