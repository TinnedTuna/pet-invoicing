package org.turner.ui;

import org.turner.model.Customer;

import javax.swing.*;

/**
 * Created by turner on 18/12/13.
 */
public class UIMain {

  private JTextField textField1;
  private JTextField textField2;
  private JTextField textField3;
  private JButton closeDiscardChangesButton;
  private JButton saveButton;
  private JPanel customerDetailsPanel;

  public static void main(String[] args) {
    JFrame frame = new JFrame("UIMain");
    frame.setContentPane(new UIMain().customerDetailsPanel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }

  public void setData(Customer data) {
    textField1.setText(data.getSecondName());
    textField2.setText(data.getAddressLineTwo());
    textField3.setText(data.getPostalCode());
  }

  public void getData(Customer data) {
    data.setSecondName(textField1.getText());
    data.setAddressLineTwo(textField2.getText());
    data.setPostalCode(textField3.getText());
  }

  public boolean isModified(Customer data) {
    if (textField1.getText() != null ? !textField1.getText().equals(data.getSecondName()) : data.getSecondName() != null) {
      return true;
    }
    if (textField2.getText() != null ? !textField2.getText().equals(data.getAddressLineTwo()) : data.getAddressLineTwo() != null) {
      return true;
    }
    if (textField3.getText() != null ? !textField3.getText().equals(data.getPostalCode()) : data.getPostalCode() != null) {
      return true;
    }
    return false;
  }
}
