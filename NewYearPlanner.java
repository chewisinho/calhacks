package calhacks;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.InputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class NewYearPlanner extends JPanel {
    
    /** Initializes the canvas. */
    public NewYearPlanner() throws IOException {
        Dimension d = new Dimension(Main.WIDTH * 2 / 3, Main.HEIGHT);
        setPreferredSize(d);
        setMinimumSize(d);
        setMaximumSize(d);
        BufferedImage background = ImageIO.read(new File("calhacks/yearGraphic.png"));
        JLabel picLabel = new JLabel(new ImageIcon(background));
        add(picLabel);
    }
}
