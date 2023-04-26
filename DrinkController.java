import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JCheckBox;

public class DrinkController implements ActionListener {
    private DrinkModel model;
    private GUI view;
  
    public DrinkController(DrinkModel model, GUI view) {
      this.model = model;
      this.view = view;
    }
  
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == view.getDrinkComboBox()) {
        model.setSelectedDrink((Drink) view.getDrinkComboBox().getSelectedItem());
      } else if (e.getSource() instanceof JCheckBox) {
        JCheckBox checkBox = (JCheckBox) e.getSource();
        AddOn addOn = model.getAddOns().get(view.getAddOnCheckBoxIndex(checkBox));
        if (checkBox.isSelected()) {
          model.addAddOn(addOn);
        } else {
          model.removeAddOn(addOn);
        }
      } else if (e.getActionCommand().equals("Reset")) {
        model.setSelectedDrink(model.getDrinks().get(0));
        model.getSelectedDrink().clearAddOns();
      }
      updateView();
    }
  
    public void updateView() {
      Drink selectedDrink = model.getSelectedDrink();
      List<AddOn> selectedAddOns = selectedDrink.getAddOns();
      view.updatePrice(selectedDrink.getTotalPrice());
      view.updateChangeLabel(selectedDrink.getTotalPrice() - view.getAmountPaid());
      view.updateAddOnCheckBoxes(selectedAddOns);
    }
  }