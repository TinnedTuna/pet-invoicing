package org.turner.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

/**
 * The main UI for getting to customers, invoices and certificate generation.
 *
 * @author turner
 */
public class MainUI {
  
  private final JFrame frame;
  private final JMenuBar menuBar;
  private final JLabel yellowLabel;
  
  public MainUI() {
    // Create the frame.
    frame = new JFrame("MainUI");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // Create a green menu bar.
    menuBar = new JMenuBar();
    menuBar.setOpaque(true);
    menuBar.setBackground(Color.green);
    menuBar.setPreferredSize(new Dimension(200, 20));
    
    // Create the label
    yellowLabel = new JLabel();
    yellowLabel.setOpaque(true);
    yellowLabel.setBackground(Color.yellow);
    yellowLabel.setPreferredSize(new Dimension(200, 180));
    
    // Add the menu bar and label to the frame.
    frame.setJMenuBar(menuBar);
    frame.getContentPane().add(yellowLabel, BorderLayout.CENTER);
    
    // Pack it all up.
    frame.pack();   
  }
  
  public void show() {
    frame.setVisible(true);
  }
}
