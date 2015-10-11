package calhacks;

import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    
    public static final int WIDTH = 1280, HEIGHT = 720; 

    public static void createGUI(Schedule schedule) throws IOException {
       JFrame f = new JFrame("demo");
       f.setSize(WIDTH, HEIGHT);
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       JComponent contentPane = new NGUI(WIDTH, HEIGHT, schedule);
       contentPane.setOpaque(true);
       f.setContentPane(contentPane);

       f.pack();

       f.setResizable(false);
       f.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        ParseFromText.run();
        Schedule _schedule = new Schedule();
        SwingUtilities.invokeLater(new Runnable() {
          public void run() {
              try {
                  createGUI(_schedule);
              } catch (IOException ex) {
                  ex.printStackTrace();
              }
          }
       });
    }
}
