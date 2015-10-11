package calhacks;

import javax.swing.*;
import java.awt.*;
import objectdraw.*;
import Acme.*;

/**
 * @author chris
 * NGUI class for four year plan
*/
public class NGUI extends JPanel {

   //private int width, height, 
   private static Color BUTTON_COLOR = new Color(0x29, 0x28, 0x29);
   
   /**
    * Constructor for a NGUI
    */
   public NGUI(int width, int height) {

      //JPanel header = new JPanel();
      JPanel wrapper = new JPanel();
      wrapper.setLayout(new GridBagLayout());

      GridBagConstraints constraint = new GridBagConstraints();

      String[] test = {"hi", "how", "are", "you"};
      
      Panel yearGrid = new NewYearPlanner();

      JComboBox<String> depts = new JComboBox<String>(test);
      JComboBox<String> courses = new JComboBox<String>(test);
      JComboBox<String> terms = new JComboBox<String>(test);
      JButton addClass = new JButton("add class");

      addClass.setBackground(BUTTON_COLOR);

      JPanel rightPanel = new JPanel();
      rightPanel.setLayout(new GridLayout(4, 1, 0, 100));
      forceSize(rightPanel, new Dimension(width * 1/3, height * 2/3));

      rightPanel.setBackground(Color.GREEN);
      rightPanel.add(depts);
      rightPanel.add(courses);
      rightPanel.add(terms);
      rightPanel.add(addClass);

      constraint.fill = GridBagConstraints.BOTH;

      constraint.weightx = 1.0;
      constraint.gridx = 0;
      constraint.gridy = 0;
      constraint.gridwidth = 2;
      constraint.gridheight = GridBagConstraints.REMAINDER;
      wrapper.add(yearGrid);

      constraint.gridwidth = GridBagConstraints.REMAINDER;
      wrapper.add(rightPanel);

      //add(header, BorderLayout.PAGE_START);
      add(wrapper);
   }

   private void forceSize(Component c, Dimension d) {
      c.setPreferredSize(d);
      c.setMinimumSize(d);
      c.setMaximumSize(d);
   }

}
