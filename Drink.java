import java.util.ArrayList;
import java.util.List;

public class Drink {
    private String name;
    private DrinkPrice price;
    private List<AddOn> addOns;
    private DrinkStrategy strategy;
    public Drink(String name, DrinkPrice price) {
        this.name = name;
        this.price = price;
        this.addOns = new ArrayList<>();
    }

    public void addAddOn(AddOn addOn) {
        addOns.add(addOn);
    }

    public void removeAddOn(AddOn addOn) {
        addOns.remove(addOn);
    }

    public String getName() {
        return name;
    }

    public DrinkPrice getPrice() {
        return price;
    }

    public List<AddOn> getAddOns() {
        return addOns;
    }

    public double getTotalPrice() {
        double totalPrice = price.getPrice();
        for (AddOn addOn : addOns) {
            totalPrice += addOn.getPrice().getPrice();
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return name;
    }

    public void setStrategy(DrinkStrategy strategy) {
        this.strategy = strategy;
    }
}
