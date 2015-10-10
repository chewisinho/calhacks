import objectdraw.*;
import Acme.*;

/**
 * GUI class for four year plan
 */
public class GUI extends WindowController {
   
   private static int WIDTH;
   private static int HEIGHT;

   /**
    * Constructor for a GUI
    * @param args command line arguments; pass them in from main
    * @param width width of the window
    * @param height height of the window
    */
   public GUI(String[] args, int width, int height) {
      new Acme.MainFrame(this, args, width, height);
      WIDTH = width;
      HEIGHT = height;
   }

   /**
    * Runs on click of the mouse inside the GUI
    * @param point point in the windows at which the mouse clicked
    */
	public void onMouseClick(Location point) {
      System.out.println("YOOOOOO");
   }
   
}
