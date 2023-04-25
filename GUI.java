import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class GUI extends JFrame implements ActionListener, DrinkObserver {
  private List < Drink > drinks;
  private List < AddOn > addOns;
  private JComboBox < Drink > drinkComboBox;
  private JCheckBox[] addOnCheckBoxes;
  private JLabel priceLabel;
  private List < Order > orderHistory; // new field for order history
  DrinkStrategy basicStrategy = new BasicDrinkStrategy();
  DrinkStrategy happyHourStrategy = new HappyHourDrinkStrategy();

  @Override
  public void update(Drink drink) {
    // Update the drinkComboBox to reflect the new drink
    drinkComboBox.setSelectedItem(drink);
  }

  public GUI() {
    super("Selling Drink");
    orderHistory = new ArrayList < > (); // initialize order history

    // Initialize drinks and add-ons
    drinks = DrinkSingleton.getInstance().getDrinks();
    addOns = AddOnSingleton.getInstance().getAddOns();

    // Create GUI components
    JPanel mainPanel = new JPanel(new BorderLayout());

    JPanel drinkPanel = new JPanel(new FlowLayout());
    drinkPanel.add(new JLabel("Drink:"));
    drinkComboBox = new JComboBox < > (drinks.toArray(new Drink[0]));
    drinkComboBox.addActionListener(this);
    drinkPanel.add(drinkComboBox);

    JPanel addOnPanel = new JPanel(new GridLayout(addOns.size(), 1));
    addOnPanel.setBorder(BorderFactory.createTitledBorder("Add-Ons"));
    addOnCheckBoxes = new JCheckBox[addOns.size()];
    for (int i = 0; i < addOns.size(); i++) {
      addOnCheckBoxes[i] = new JCheckBox(addOns.get(i).getName());
      addOnCheckBoxes[i].addActionListener(this);
      addOnPanel.add(addOnCheckBoxes[i]);
    }

    JPanel pricePanel = new JPanel(new FlowLayout());
    pricePanel.add(new JLabel("Price:"));
    priceLabel = new JLabel("$0.00");
    pricePanel.add(priceLabel);

    JPanel amountPaidPanel = new JPanel(new FlowLayout());
    amountPaidPanel.add(new JLabel("User will have $10 to pay"));

    JPanel buttonPanel = new JPanel(new FlowLayout());
    JButton resetButton = new JButton("Reset");
    resetButton.addActionListener(this);
    buttonPanel.add(resetButton);

    // Add checkout button
    JButton checkoutButton = new JButton("Checkout");
    checkoutButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Drink selectedDrink = (Drink) drinkComboBox.getSelectedItem();
        List < AddOn > selectedAddOns = new ArrayList < > ();
        for (int i = 0; i < addOnCheckBoxes.length; i++) {
          if (addOnCheckBoxes[i].isSelected()) {
            selectedAddOns.add(addOns.get(i));
          }
        }
        Order order = new Order(selectedDrink, selectedAddOns);
        orderHistory.add(order);
        JOptionPane.showMessageDialog(GUI.this, "Order saved!");

        // Write order to file
        try {
          FileWriter writer = new FileWriter("order.txt", true);
          writer.write(order.toString() + "\n");
          writer.close();
        } catch (IOException ex) {
          ex.printStackTrace();
        }
      }
    });
    buttonPanel.add(checkoutButton);

    // Add components to main panel
    mainPanel.add(drinkPanel, BorderLayout.NORTH);
    mainPanel.add(addOnPanel, BorderLayout.CENTER);
    mainPanel.add(pricePanel, BorderLayout.SOUTH);
    mainPanel.add(amountPaidPanel, BorderLayout.WEST);
    mainPanel.add(buttonPanel, BorderLayout.EAST);

    // Set up frame
    setContentPane(mainPanel);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
    setSize(500, 240);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == drinkComboBox) {
      updatePrice(10.0);
    } else if (e.getSource() instanceof JCheckBox) {
      updatePrice(10.0);
    } else if (e.getActionCommand().equals("Reset")) {
      reset();
    }
  }

  private boolean isHappyHour() {
    Calendar now = Calendar.getInstance();
    int hour = now.get(Calendar.HOUR_OF_DAY);
    return (hour >= 17 && hour < 19); // Happy hour is from 5pm to 7pm
  }

  private void updatePrice(double amountPaid) {
    Drink selectedDrink = (Drink) drinkComboBox.getSelectedItem();
    if (isHappyHour()) {
      selectedDrink.setStrategy(happyHourStrategy);
    } else {
      selectedDrink.setStrategy(basicStrategy);
    }
    selectedDrink.getAddOns().clear();
    for (int i = 0; i < addOnCheckBoxes.length; i++) {
      if (addOnCheckBoxes[i].isSelected()) {
        selectedDrink.addAddOn(addOns.get(i));
      }
    }
    double totalPrice = selectedDrink.getTotalPrice();
    priceLabel.setText(String.format("$%.2f", totalPrice));

    Payment payment = new Payment(totalPrice);
    payment.setAmountPaid(amountPaid);

    double change = payment.getChange();
    JLabel changeLabel = new JLabel(String.format("Change: $%.2f", change));
    JPanel pricePanel = (JPanel) priceLabel.getParent();
    Component[] components = pricePanel.getComponents();
    for (Component component: components) {
      if (component instanceof JLabel && ((JLabel) component).getText().startsWith("Change:")) {
        pricePanel.remove(component);
        break;
      }
    }
    pricePanel.add(changeLabel);
    pricePanel.revalidate();
    pricePanel.repaint();
  }

  private void reset() {
    drinkComboBox.setSelectedIndex(0);
    for (JCheckBox checkBox: addOnCheckBoxes) {
      checkBox.setSelected(false);
    }
    priceLabel.setText("$0.00");
  }

  public static void main(String[] args) {
    new GUI();
  }
}
// new Order class
class Order {
  private Drink drink;
  private List < AddOn > addOns;

  public Order(Drink drink, List < AddOn > addOns) {
    this.drink = drink;
    this.addOns = addOns;
  }

  public Drink getDrink() {
    return drink;
  }

  public List < AddOn > getAddOns() {
    return addOns;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(drink.getName());
    if (!addOns.isEmpty()) {
      sb.append(" with ");
      for (int i = 0; i < addOns.size(); i++) {
        sb.append(addOns.get(i).getName());
        if (i < addOns.size() - 1) {
          sb.append(", ");
        }
      }
    }
    sb.append(" - $").append(String.format("%.2f", drink.getTotalPrice()));
    return sb.toString();
  }
}