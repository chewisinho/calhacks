package calhacks;

import objectdraw.*;
import Acme.*;

/**
 * GUI class for four year plan
 */
public class GUI extends WindowController {

   private static int boxHeight;
   private static int boxWidth;

   public static final int LEFT_PADDING = 60, BOTTOM_PADDING = 60;
   public static final int TOP_PADDING = BOTTOM_PADDING * 2;

   //private static int  // y coord for text to be stated
   //private static int  //x coord for text to be stated

   /* Contains the schedule to be displayed. */
   private Schedule _schedule;

   public static final int WINDOW_WIDTH = 1280, WINDOW_HEIGHT = 720;

   /**
    * Constructor for a GUI
    * @param args command line arguments; pass them in from main
    * @param width width of the window
    * @param height height of the window
    */
   public GUI(String[] args, Schedule schedule) {
       _schedule = schedule;
	   new Acme.MainFrame(this, args, WINDOW_WIDTH, WINDOW_HEIGHT);
     
	   //year planner starter pack
       boxHeight = WINDOW_HEIGHT - TOP_PADDING - BOTTOM_PADDING;
       boxWidth = (WINDOW_WIDTH / Schedule.NUM_TERMS) * 2 - LEFT_PADDING;
       YearPlanner mainbox = new YearPlanner(LEFT_PADDING, TOP_PADDING,
				 boxWidth, boxHeight, canvas, schedule);
	   new Text("Four Year Planner", WINDOW_WIDTH / 2,
	           TOP_PADDING / 2 , canvas);
   }

   /**
    * Runs on click of the mouse inside the GUI
    * @param point point in the windows at which the mouse clicked
    */
	public void onMouseClick(Location point) {
      System.out.println("YOOOOOO");
   }
   
}
