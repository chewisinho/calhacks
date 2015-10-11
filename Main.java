package calhacks;

import java.io.IOException;

public class Main {
	
	private static final int WINDOW_WIDTH = 1280;
	private static final int WINDOW_HEIGHT = 720; 
	
    public static void main(String[] args) throws IOException {
        // GUI _display = new GUI(args, WINDOW_WIDTH, WINDOW_HEIGHT);
        Schedule _schedule = new Schedule();
        TextDisplay _textDisplay = new TextDisplay(_schedule);
        _textDisplay.run();
    }
}
