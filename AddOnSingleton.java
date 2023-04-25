import java.util.ArrayList;
import java.util.List;

public class AddOnSingleton {
    private static AddOnSingleton instance;
    private List<AddOn> addOns;

    private AddOnSingleton() {
        addOns = new ArrayList<>();
        addOns.add(new AddOn("Milk", new AddOnPrice(0.50)));
        addOns.add(new AddOn("Sugar", new AddOnPrice(0.25)));
        addOns.add(new AddOn("Whipped Cream", new AddOnPrice(0.75)));
    }

    public static AddOnSingleton getInstance() {
        if (instance == null) {
            instance = new AddOnSingleton();
        }
        return instance;
    }

    public List<AddOn> getAddOns() {
        return addOns;
    }
}