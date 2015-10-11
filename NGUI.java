package calhacks;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.io.IOException;

/**
 * @author chris
 * NGUI class for four year plan
*/
public class NGUI extends JPanel {

   private static Font TEXT_FONT = new Font("Century Gothic", Font.PLAIN, 12);
   private static Color BUTTON_COLOR = new Color(0x29, 0x28, 0x29);
   private static Color BUTTON_TEXT = new Color(0xff, 0xff, 0xff);

   private JComboBox<String> depts;
   private JComboBox<String> courses;
   private JComboBox<String> terms;   
   private JButton addClass;

   private GUIListener gl = new GUIListener(this);


   
   /**
    * Constructor for a NGUI
    */
   public NGUI(int width, int height) throws IOException {

      //JPanel header = new JPanel();
      JPanel wrapper = new JPanel();
      wrapper.setLayout(new GridBagLayout());

      GridBagConstraints constraint = new GridBagConstraints();

      String[] test = {"hi", "how", "are", "you",
                       "hi", "how", "are", "you",
                       "hi", "how", "are", "you",
                       "hi", "how", "are", "you", 
                       "hi", "how", "are", "you",
                       "hi", "how", "are", "you",
                       "hi", "how", "are", "you",
                       "hi", "how", "are", "you",
                       "hi", "how", "are", "you"};

      JPanel yearGrid = new JPanel(); // change back to YearPanel

      depts = new JComboBox<String>(test);
      courses = new JComboBox<String>(test);
      terms = new JComboBox<String>(test);
      addClass = new JButton("add class");

      applyStyle(depts);
      applyStyle(courses);
      applyStyle(terms);
      applyStyleButton(addClass);


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

   public void onAddClass() {
      Object dept = depts.getSelectedItem();     // these types can be of
      Object course = courses.getSelectedItem(); // Department, Course, Term
      Object term = terms.getSelectedItem();
      // do something with these
      System.out.println(dept + ", " + course + ", " + term);
   }

   /**
    * Applies the standard style to JButton objects
    * @param b JButton to style
    */
   private void applyStyleButton(JButton b) {
      applyStyle(b);
      b.setFocusPainted(false);
      b.addActionListener(gl);
   }
      

   /**
    * Applies the standard style of input components
    * @param c JComponent to style
    */
   private void applyStyle(JComponent c) {
      c.setBackground(BUTTON_COLOR);
      c.setFont(TEXT_FONT);
      c.setForeground(BUTTON_TEXT);
      c.setBorder(new EmptyBorder(0, 0, 0, 0));
   }
      

   private void forceSize(Component c, Dimension d) {
      c.setPreferredSize(d);
      c.setMinimumSize(d);
      c.setMaximumSize(d);
   }

}
