package org.turner.ui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Provides Swing ui for interacting with customer entities.
 * @author turner
 */
@Component
public class CustomerUI {
  
  private final JFrame frame;
  private final JTable customerDetailsTable;

  @Autowired
  public CustomerUI(final TableModel customerTableModel) {
    
    frame = new JFrame("Customers Table");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    customerDetailsTable = new JTable(customerTableModel);
    
    JScrollPane scrollPane = new JScrollPane(customerDetailsTable);
    customerDetailsTable.setFillsViewportHeight(true);
    frame.add(scrollPane);
    frame.pack();
  }
  
  public void show() {
    frame.setVisible(true);
  }
  
  
  
}
