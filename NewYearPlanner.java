package calhacks;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.InputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import objectdraw.*;

public class NewYearPlanner extends JPanel {
    
    private Schedule _schedule;
    private static final int LEFT_PADDING = 60;
    private static final int TOP_X = 75, TOP_Y = 120, TERM_HEIGHT = (720 - 120 - 60) / Schedule.NUM_YEARS,
            TERM_WIDTH = (1280 * 2 / 3 - LEFT_PADDING) / Schedule.NUM_TERMS;
    private JLabel picLabel;
    private Canvas 
    
    /** Initializes the canvas. */
    public NewYearPlanner(Schedule schedule) throws IOException {
        _schedule = schedule;
        Dimension d = new Dimension(Main.WIDTH * 2 / 3, Main.HEIGHT);
        setPreferredSize(d);
        setMinimumSize(d);
        setMaximumSize(d);
        BufferedImage background = ImageIO.read(new File("calhacks/yearGraphic.png"));
        picLabel = new JLabel(new ImageIcon(background));
        add(picLabel);
    }

    public void paintComponent(Graphics g) {
       Graphics2D g2 = (Graphics2D) g;
       g2.setColor(Color.BLACK);
       g2.fillRect(0, 0, 100, 100);
       drawSchedule(g2);
    }

    private void drawSchedule(Graphics2D g) {
       add(picLabel);
       for (int i = 0; i < Schedule.NUM_YEARS * Schedule.NUM_TERMS; i++) {
           System.out.println("Entering loop " + i);
           Term t = _schedule.getTerm(i);
           int j = 0;
           for (Course c : t.courses) {
               g.drawString(c.getCourseName(), TOP_X + TERM_WIDTH * (i % Schedule.NUM_YEARS),
                       TOP_Y + TERM_HEIGHT * (i / Schedule.NUM_YEARS) + 20 * j);
               j += 1;
           }
       }
    }
    
    public void refresh() throws IOException {
        add(picLabel);
        repaint(); // testing paintComponent
        System.out.println("Entered REFRESH.");
        System.out.println(Schedule.NUM_YEARS * Schedule.NUM_TERMS);
        System.out.println("After loop.");
    }
}
