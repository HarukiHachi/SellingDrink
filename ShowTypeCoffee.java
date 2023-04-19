import java.util.ArrayList;

public class ShowTypeCoffee {
    private ArrayList<Coffee> coffeeList;

    public ShowTypeCoffee(ArrayList<Coffee> coffeeList) {
        this.coffeeList = coffeeList;
    }

    public void showByType(String type) {
        System.out.println("Showing all " + type + " coffees:");
        for (Coffee coffee : coffeeList) {
            if (coffee.getType().equalsIgnoreCase(type)) {
                System.out.println(coffee.getType() + ": $" + coffee.getPrice());
            }
        }
    }
}
