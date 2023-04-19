public class Order {
  private Customer customer;
  private Drink drink;
  private int quantity;
  private double totalPrice;

  public Order(Customer customer, Drink drink, int quantity, double totalPrice) {
    this.customer = customer;
    this.drink = drink;
    this.quantity = quantity;
    this.totalPrice = totalPrice;
  }
  public Customer getCustomer() {
    return customer;
  }

  public Drink getDrink() {
    return drink;
  }

  public int getQuantity() {
    return quantity;
  }

  public double getTotalPrice() {
    return totalPrice;
  }
}
