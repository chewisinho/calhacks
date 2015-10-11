package calhacks;

import objectdraw.*;

public class YearPlanner {

    private static FramedRect yearPlanner;
    private final Schedule _schedule;
    private final DrawingCanvas _canvas;
    public final int BOX_HEIGHT, BOX_WIDTH;
    
    public YearPlanner(int x, int y, int width, int height,
            DrawingCanvas canvas, Schedule schedule) {

        _schedule = schedule;
        _canvas = canvas;
        BOX_WIDTH = width;
        BOX_HEIGHT = height;

        /** Draws the main box. */
        yearPlanner = new FramedRect(x, y, BOX_WIDTH, BOX_HEIGHT,
                canvas);

        /** Parameters for the box size. */
        final int YEAR_HEIGHT = BOX_HEIGHT / Schedule.NUM_YEARS,
                SEMESTER_WIDTH = BOX_WIDTH / Schedule.NUM_TERMS;

        /** Draws the horizontal lines. */
        int tempY = y;
        new Line(x, tempY += YEAR_HEIGHT, x + BOX_WIDTH, tempY, canvas);
        new Line(x, tempY += YEAR_HEIGHT, x + BOX_WIDTH, tempY, canvas);
        new Line(x, tempY += YEAR_HEIGHT, x + BOX_WIDTH, tempY, canvas);

        /** Draws the vertical lines. */
        int tempX = x;
        new Line(tempX += SEMESTER_WIDTH, y, tempX, y + BOX_HEIGHT, canvas);
        new Line(tempX += SEMESTER_WIDTH, y, tempX, y + BOX_HEIGHT, canvas);
    }
    
    public void display() {
        for (int i = 0; i < Schedule.NUM_YEARS * Schedule.NUM_TERMS; i += 1) {
            Term t = _schedule.getTerm(i);
            for (Course c : t.courses) {
                int courseHeight = (GUI.TOP_PADDING
                        + (BOX_HEIGHT / Schedule.NUM_YEARS + 5) * (i / Schedule.NUM_YEARS)
                        + ((BOX_HEIGHT / Schedule.NUM_YEARS) / Term.MAX_CLASSES) * (i % Schedule.NUM_YEARS));
                int courseWidth = (GUI.LEFT_PADDING
                        + (BOX_WIDTH / Schedule.NUM_TERMS + 5) * (i / Schedule.NUM_TERMS));
                new Text(c.getCourseName(), courseHeight, courseWidth, _canvas);
            }
        }
    }
}
