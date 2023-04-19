# SellingDrink

This is a project making by 3 mans
519H0274 - Le Dac Chinh
519H0343 - Bao Hoang Qui
519H0113 - Ngo Gia Phat

# Description about SellingDrink Project

    - Drink: A class representing a drink, with properties such as name, description, price, and ingredients. This class provides information about the drinks available for sale.

    - Customer: A class representing a customer, with properties such as name, email, and loyalty level. This class provides information about the customers and their loyalty levels.

    - Order: A class representing an order, with properties such as customer, drink, quantity, and total price. This class provides information about the orders made by the customers.

    - DrinkFactory: A class implementing the Factory pattern to create different types of drinks based on user input. This class creates new instances of the Drink class based on user input.

    - PriceCalculatorStrategy: An interface implementing the Strategy pattern to calculate the price of a drink based on the customer's loyalty level. This interface provides a common way to calculate the price of a drink based on different strategies.

    - Regular PriceCalculator: A class implementing PriceCalculatorStrategy interface to calculate the regular price of a drink. This class calculates the regular price of a drink for a customer who is not a VIP.

    - VIPPriceCalculator: A class implementing PriceCalculatorStrategy interface to calculate the discounted price of a drink for VIP customers. This class calculates the discounted price of a drink for a customer who is a VIP.

    - DatabaseConnection: A class implementing the Singleton pattern to manage access to the database. This class manages access to the database, ensuring that only one instance is created at a time.

    - DrinkController: A class implementing the MVC pattern to handle user input and update the view accordingly. This class handles user input and updates the view accordingly.

    - DrinkView: A class implementing the MVC pattern to display the drinks available for sale. This class displays the drinks available for sale in the view.

    - CustomerView: A class implementing the MVC pattern to display the customer loyalty levels and corresponding discounts. This class displays the customer loyalty levels and corresponding discounts in the view.

    - OrderView: A class implementing the MVC pattern to display the orders made by the customers. This class displays the orders made by the customers in the view.

    - Main: A class containing the main method to run the application. This class is responsible for starting the application and coordinating the interaction between different classes.
