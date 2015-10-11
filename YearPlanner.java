package calhacks;

import objectdraw.*;

public class YearPlanner {

    private static FramedRect yearplanner; 
    
        public YearPlanner (int x, int y, int BOX_WIDTH, int BOX_HEIGHT,
                            DrawingCanvas canvas){
            
            //draw main box
            yearplanner = new FramedRect ( x , y, BOX_WIDTH, BOX_HEIGHT,
                                           canvas);
            
            //lines for planner
            int yearheight= BOX_HEIGHT / 4;
            int semesterwidth = BOX_WIDTH / 3;
            
            //horizontal lines
            int tempy = y;
            new Line( x, tempy +=yearheight, x + BOX_WIDTH, tempy, canvas);
            new Line( x, tempy += yearheight, x + BOX_WIDTH, tempy, canvas);
            new Line( x, tempy += yearheight, x + BOX_WIDTH, tempy, canvas);
            
            //vertical lines
            int tempx = x;
            new Line( tempx += semesterwidth, y, tempx, y + BOX_HEIGHT, canvas);
            new Line( tempx += semesterwidth, y, tempx, y + BOX_HEIGHT, canvas);
            
            
            
        }
}
