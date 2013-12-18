/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.turner.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.turner.model.Customer;
import org.turner.persistence.CustomerDAO;

/**
 *
 * @author turner
 */
public class CustomerPanel extends JPanel {
  
  CustomerDAO customerDAO;
  
  JTextField surnameTextField;
  JTextField addressOneTextField;
  JTextField postCodeTextField;
  
  public CustomerPanel(CustomerDAO customerDAO) {
    this.customerDAO = customerDAO;
  }
  
  public JPanel getDetailsPanel(Customer customer) {
    JPanel panel = new JPanel();
    surnameTextField = new JTextField();
    addressOneTextField = new JTextField();
    postCodeTextField = new JTextField();
      
    JButton saveButton = new JButton("Save");

      saveButton.addMouseListener(new MouseListener() {

      @Override
      @Transactional
      public void mouseClicked(MouseEvent arg0) {
      }

      @Override
      public void mousePressed(MouseEvent arg0) {
        Customer customer = new Customer(CustomerPanel.this.getSurname(), CustomerPanel.this.getAddressLineOne(), CustomerPanel.this.getPostCode());
        customerDAO.save(customer);
      }

      @Override
      public void mouseReleased(MouseEvent arg0) {
      }

      @Override
      public void mouseEntered(MouseEvent arg0) {
      }

      @Override
      public void mouseExited(MouseEvent arg0) {
      }
    });
    JButton closeButton = new JButton("Close (discard changes)");
    panel.add(surnameTextField);
    panel.add(addressOneTextField);
    panel.add(postCodeTextField);
    panel.add(saveButton);
    panel.add(closeButton);
    return panel;
  }
  
  protected String getSurname() {
    return surnameTextField.getText();
  }
  
  protected String getAddressLineOne() {
    return addressOneTextField.getText();
  }
  
  protected String getPostCode() {
    return postCodeTextField.getText();
  }
  
  
  
}
