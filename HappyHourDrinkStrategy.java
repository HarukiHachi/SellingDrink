public class HappyHourDrinkStrategy implements DrinkStrategy {
    private final double DISCOUNT = 0.2;

    @Override
    public double calculatePrice(Drink drink) {
        return drink.getTotalPrice() * DISCOUNT;
    }
}