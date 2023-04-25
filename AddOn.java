public class AddOn {
    private String name;
    private AddOnPrice price;

    public AddOn(String name, AddOnPrice price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public AddOnPrice getPrice() {
        return price;
    }
}
