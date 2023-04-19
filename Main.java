import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    // Initialize drinks and customers
    Drink coffee = new Drink("Coffee", "Hot drink made from roasted coffee beans", 2.5, Arrays.asList("Coffee beans", "Water"));
    Drink tea = new Drink("Tea", "Hot drink made from brewed tea leaves", 2.0, Arrays.asList("Tea leaves", "Water"));
    Drink soda = new Drink("Soda", "Cold carbonated drink", 1.5, Arrays.asList("Soda water", "Syrup"));
    List<Drink> drinks = Arrays.asList(coffee, tea, soda);
    }
}
