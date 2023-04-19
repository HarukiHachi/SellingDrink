import java.util.Collections;
import java.util.List;

public class DrinkFactory {
  public static Drink createDrink(String name, String description, double price, List<String> ingredients) {
    return new Drink(name, description, price, ingredients);
  }
}
