/*
 * Event listener for the GUI
 */
package calhacks;

import java.awt.event.*;
import java.awt.event.MouseMotionListener;

/**
 * @author chris
 */
public class GUIListener implements ActionListener, MouseMotionListener {

   private NGUI _ngui;
   private static String lastSeenDept;

   /**
    * ctor for GUIListener
    * @param ngui the NGUI object being listened to
    */
   public GUIListener(NGUI ngui) {
      _ngui = ngui;
   }

   public void actionPerformed(ActionEvent e) {
       try {
           String command = e.getActionCommand();
           switch (command) {
              case "add class":
                 _ngui.onAddClass();
                 break;
              default:
                 break;
           }
       } catch (Exception ex) {
           
       }
   }
   
   public void mouseMoved(MouseEvent event) {
       if (lastSeenDept == null) {
           lastSeenDept = (String) _ngui.depts.getSelectedItem();
       }
       try {
           if (!lastSeenDept.equals((String) _ngui.depts.getSelectedItem())) {
               lastSeenDept = (String) _ngui.depts.getSelectedItem();
               _ngui.updateCourses();
               System.out.println("JUST FINISHED UPDATING COURSES");
               _ngui._yearGrid.refresh();
           }
       } catch (Exception ex) {
           
       }
   }
   
   public void mouseDragged(MouseEvent event) {
       
   }
}
