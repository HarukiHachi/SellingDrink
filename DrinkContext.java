public class DrinkContext {
    private DrinkStrategy strategy;

    public DrinkContext(DrinkStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(DrinkStrategy strategy) {
        this.strategy = strategy;
    }

    public double executeStrategy(Drink drink) {
        return strategy.calculatePrice(drink);
    }
}