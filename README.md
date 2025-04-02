# Task: 
Develop a pizza ordering service “PizzaFactory” to manage their pizza orders. 

# Description : 
A simple UI client is deployed on self-service terminals where customers can enter their orders by selecting various options. 
The self-service terminal client receives the menu and other information from the “PizzaFactory” service and also forwards all
order creation requests to the same service.

The PizzaFactory backend service keeps a tab on existing inventory of the required ingredients
and forwards received orders to backend systems. 

Need to come up with a data model and create a basic service using plain java classes that serve as a proof of concept for the
pizza ordering service.
`
# The Goal
Your application needs to showcase your talent for conceptualizing a problem and formulating
a solution while adhering to good programming practices and principles.
Please note:
1. No UI Client needs to be implemented.
2. Basic service should be implemented using plain java classes and simple in memory
data store (Collections).
3. Important unit tests to validate business requirements should be implemented.

# Requirements:
• The service will be accepting requests from multiple self-service terminals.
• Customers can select one or more Pizzas from the menu and then customize them
with available options.
• Customers should be able to select a type of crust and add extra toppings.
• Customers should be able to verify their order, check the amount and place the order
Once the order is received service will verify the business rules and confirm the order.
Payment/order processing workflow is not required to implement to keep it simple.
• Customers can also place side orders along with the pizza order.
• The “PizzaFactory” ensures that appropriate inventory is available before allowing
customers to proceed with their orders. It also makes best efforts to utilize inventory in
an optimal manner to fulfill maximum orders.
• Customers can’t cancel the order once it is placed.
• The vendor can restock inventory through “PizzaFactory” service.
• The vendor should be able to add new pizzas, toppings, sides and also change prices.
• The design should require minimal changes in the code while adding new business rules.

# The menu:
# Vegetarian Pizza:
1. Deluxe Veggie: (Regular: Rs. 150 Medium: Rs. 200 Large: Rs. 325)
2. Cheese and corn: (Regular: Rs. 175 Medium: Rs. 375 Large: Rs. 475)
3. Paneer Tikka: (Regular: Rs. 160 Medium: Rs. 290 Large: Rs. 340)
# Non-Vegetarian:
1. Non-Veg Supreme: (Regular: Rs 190 Medium: Rs 325 Large: Rs 425)
2. Chicken Tikka: (Regular: Rs 210 Medium: Rs 370 Large: Rs 500)
3. Pepper Barbecue Chicken (Regular: Rs 220 Medium: Rs 380 Large: Rs 525)
# Type of crust:
1. New hand tossed
2. Wheat thin crust
3. Cheese Burst
4. Fresh pan pizza
# Extra toppings:
# Veg toppings:
1. Black olive (Rs 20)
2. Capsicum (Rs 25)
3. Paneer (Rs 35)
4. Mushroom (Rs 30)
5. Fresh tomato (Rs 10)
# Non-Veg toppings:
1. Chicken tikka (Rs 35)
2. Barbeque chicken (Rs 45)
3. Grilled chicken (Rs 40)
4. Extra cheese: (Rs 35)
# Sides:
1. Cold drink (Rs 55)
2. Mousse cake (Rs. 90)

# Business rules:
● Vegetarian pizza cannot have a non-vegetarian topping.
● Non-vegetarian pizza cannot have paneer topping.
● Only one type of crust can be selected for any pizza.
● You can add only one of the non-veg toppings in non-vegetarian pizza.
● Large size pizzas come with any 2 toppings of customers choice with no additional
cost.
