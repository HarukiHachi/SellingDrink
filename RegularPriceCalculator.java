public class RegularPriceCalculator implements PriceCalculatorStrategy {
  @Override
  public double calculatePrice(Customer customer, Drink drink) {
    return drink.getPrice();
  }
}
