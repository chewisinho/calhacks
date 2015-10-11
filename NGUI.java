package calhacks;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.io.IOException;
import java.util.Vector;
import java.util.ArrayList;

/**
 * @author chris
 * NGUI class for four year plan
*/
public class NGUI extends JPanel {

   private static Font TEXT_FONT = new Font("Century Gothic", Font.PLAIN, 12);
   private static Color BUTTON_COLOR = new Color(0x29, 0x28, 0x29);
   private static Color BUTTON_TEXT = new Color(0xff, 0xff, 0xff);

   private JComboBox<String> depts;
   protected JComboBox<String> courses;
   private JComboBox<String> terms;   
   private JButton addClass;
   
   private ArrayList<Department> departmentList;

   private GUIListener gl = new GUIListener(this);

   /**
    * Constructor for a NGUI
    */
   public NGUI(int width, int height) throws IOException {

      //JPanel header = new JPanel();
      JPanel wrapper = new JPanel();
      wrapper.setLayout(new GridBagLayout());
      departmentList = Parse.getClassList();

      GridBagConstraints constraint = new GridBagConstraints();
      
      String[] departments = new String[Parse.getDepartments().size()];
      Parse.getDepartments().toArray(departments);
      Vector<String> empty = new Vector<String>();
      String[] _terms = {"1st Year Fall", "1st Year Spring", "1st Year Summer",
              "2nd Year Fall", "2nd Year Spring", "2nd Year Summer",
              "3rd Year Fall", "3rd Year Spring", "3rd Year Summer",
              "4th Year Fall", "4th Year Spring", "4th Year Summer"};

      JPanel yearGrid = new NewYearPlanner();

      depts = new JComboBox<String>(departments);
      courses = new JComboBox<String>(empty);
      terms = new JComboBox<String>(_terms);
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
   
   public void updateCourses() {
       Vector<String> courseList = new Vector<String>();
       String deptName = (String) depts.getSelectedItem();
       for (Department d : departmentList) {
           if (deptName.equals(d._name)) {
               for (ArrayList<String> course : d.courses) {
                   courseList.add(course.get(0));
               }
               break;
           }
       }
       courses.removeAllItems();
       for (String courseNum : courseList) {
           courses.addItem(courseNum);
       }
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
