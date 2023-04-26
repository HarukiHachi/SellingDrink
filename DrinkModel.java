import java.util.List;

public class DrinkModel {
  private List<Drink> drinks;
  private List<AddOn> addOns;
  private Drink selectedDrink;

  public DrinkModel() {
    drinks = DrinkSingleton.getInstance().getDrinks();
    addOns = AddOnSingleton.getInstance().getAddOns();
    selectedDrink = drinks.get(0);
  }

  public List<Drink> getDrinks() {
    return drinks;
  }

  public List<AddOn> getAddOns() {
    return addOns;
  }

  public Drink getSelectedDrink() {
    return selectedDrink;
  }

  public void setSelectedDrink(Drink drink) {
    selectedDrink = drink;
  }

  public void addAddOn(AddOn addOn) {
    selectedDrink.addAddOn(addOn);
  }

  public void removeAddOn(AddOn addOn) {
    selectedDrink.removeAddOn(addOn);
  }
}