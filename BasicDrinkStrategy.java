public class BasicDrinkStrategy implements DrinkStrategy {
    @Override
    public double calculatePrice(Drink drink) {
        return drink.getTotalPrice();
    }
}