/*
 * Event listener for the GUI
 */
package calhacks;

import java.awt.event.*;

/**
 * @author chris
 */
public class GUIListener implements ActionListener {

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
}
