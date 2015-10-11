package calhacks;

import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720; 

    public static void createGUI() {
       JFrame f = new JFrame("demo");
       f.setSize(WIDTH, HEIGHT);
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       JComponent contentPane = new NGUI(WIDTH, HEIGHT);
       contentPane.setOpaque(true);
       f.setContentPane(contentPane);

       f.pack();

       f.setResizable(false);
       f.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        Parse.run();
        Schedule _schedule = new Schedule();
        SwingUtilities.invokeLater(new Runnable() {
          public void run() {
             createGUI();
          }
       });
    }
}
