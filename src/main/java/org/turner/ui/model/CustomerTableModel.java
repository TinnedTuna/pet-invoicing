package org.turner.ui.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.turner.model.Customer;
import org.turner.persistence.CustomerRepository;

/**
 * Maps between a collection of Customer objects and the table model used to 
 * display those details.
 *
 * @author turner
 */
@Component
public class CustomerTableModel implements TableModel {

  private static final String[] COLUMN_NAMES = new String[] { "Title", "Surname", 
    "Firstname", "Phone Number", "Post Code", "Notes"};
  
  private final CustomerRepository customerRepository;
  private List<Customer> customers;
  
  @Autowired
  public CustomerTableModel(final CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }
  
  @Override
  public int getRowCount() {
    return getCustomers().size();
  }

  @Override
  public int getColumnCount() {
    return 6;
  }

  @Override
  public String getColumnName(int column) {
    return COLUMN_NAMES[column];
  }

  @Override
  public Class<?> getColumnClass(int column) {
    return String.class;
  }

  @Override
  public boolean isCellEditable(int row, int column) {
    return true;
  }

  @Override
  public Object getValueAt(int row, int column) {
    Customer customer = customers.get(row);
    switch (column) {
      case 0:
        // Get the title.
        return customer.getTitle().getTitle();
      case 1:
        // Surname
        return customer.getSecondName();
      case 2:
        // First name
        return customer.getFirstName();
      case 3:
        // Phone num.
        return customer.getPhoneNumber();
      case 4:
        // Post code
        return customer.getPostalCode();
      case 5:
        // Notes
        return customer.getNotes();
    }
    return "ROW/COLUMN NOT SUPPORTED "+row+ "/"+column;
  }

  @Override
  public void setValueAt(Object arg0, int arg1, int arg2) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void addTableModelListener(TableModelListener arg0) {
    
  }

  @Override
  public void removeTableModelListener(TableModelListener arg0) {
    
  }

  public List<Customer> getCustomers() {
    if (customers == null) {
      Iterable<Customer> findAll = customerRepository.findAll();
      int customersSize = (int) customerRepository.count();
      customers = new ArrayList<>(customersSize);
      for (Customer customer : findAll) {
       customers.add(customer);
      }
    }
    return customers;
  }
  
  
}
