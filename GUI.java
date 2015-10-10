package calhacks;

import objectdraw.*;
import Acme.*;

/**
 * GUI class for four year plan
 */
public class GUI extends WindowController {
   
   private static int width; //width of window
   private static int height; //height of window
   private static int boxheight; //yearplanner height
   private static int boxwidth; //yearplanner width
   
   private static final int LEFT_PADDING = 40;
   private static final int BOTTOM_PADDING = 40; 
   static final int TOP_PADDING = BOTTOM_PADDING * 3; 
   
   private static int texty = TOP_PADDING / 2; // y coord for text to be stated
   private static int textx; //x coord for text to be stated

   
   /**
    * Constructor for a GUI
    * @param args command line arguments; pass them in from main
    * @param width width of the window
    * @param height height of the window
    */
   public GUI(String[] args, int w, int h) {
	   width = w;
	   height = h;
	   new Acme.MainFrame(this, args, width, height);
     
	   //year planner starter pack
       boxheight = h - TOP_PADDING - BOTTOM_PADDING;
       boxwidth = (w / 3) * 2 - LEFT_PADDING;
       YearPlanner mainbox = new YearPlanner (LEFT_PADDING ,TOP_PADDING,
				 boxwidth, boxheight, canvas);
  
   }

   /**
    * Runs on click of the mouse inside the GUI
    * @param point point in the windows at which the mouse clicked
    */
	public void onMouseClick(Location point) {
      System.out.println("YOOOOOO");
      
      
      
   }
   
}
