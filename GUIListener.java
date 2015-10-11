/*
 * Event listener for the GUI
 */
package calhacks;

import java.awt.event.*;
import java.awt.event.MouseListener;

/**
 * @author chris
 */
public class GUIListener implements ActionListener, MouseListener {

   private NGUI _ngui;

   /**
    * ctor for GUIListener
    * @param ngui the NGUI object being listened to
    */
   public GUIListener(NGUI ngui) {
      _ngui = ngui;
   }

   public void actionPerformed(ActionEvent e) {
      String command = e.getActionCommand();
      switch (command) {
         case "add class":
            _ngui.onAddClass();
            break;
         default:
            break;
      }
   }
   
   public void mouseClicked() {
       _ngui.updateCourses();
   }
   
   public void mousePressed() {
       
   }
   
   public void mouseReleased() {
       
   }
   
   public void mouseEntered() {
       
   }
   
   public void mouseExited() {
       
   }
}
