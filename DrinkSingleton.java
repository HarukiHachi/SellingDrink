
import java.util.ArrayList;
import java.util.List;

public class DrinkSingleton {
    private static DrinkSingleton instance;
    private List<Drink> drinks;

    private DrinkSingleton() {
        drinks = new ArrayList<>();
        drinks.add(new Drink("Coffee", new DrinkPrice(2.50)));
        drinks.add(new Drink("Tea", new DrinkPrice(2.00)));
        drinks.add(new Drink("Soda", new DrinkPrice(1.50)));
        drinks.add(new Drink("CockTail", new DrinkPrice(2)));
    }

    public static DrinkSingleton getInstance() {
        if (instance == null) {
            instance = new DrinkSingleton();
        }
        return instance;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void removeDrink(Drink drink) {
        drinks.remove(drink);
    }
}
