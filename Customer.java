public class Customer {
  private String name;
  private String email;
  private boolean isVip;

  public Customer(String name, String email, boolean isVip) {
    this.name = name;
    this.email = email;
    this.isVip = isVip;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public boolean isVip() {
    return isVip;
  }
}
