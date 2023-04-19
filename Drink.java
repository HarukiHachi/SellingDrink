import java.util.List;

public class Drink {
  private String name;
  private String description;
  private double price;
  private List<String> ingredients;

  public Drink(String name, String description, double price, List<String> ingredients) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.ingredients = ingredients;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public double getPrice() {
    return price;
  }

  public List<String> getIngredients() {
    return ingredients;
  }
}
