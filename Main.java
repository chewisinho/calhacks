package calhacks;

public class Main {
	
	private static final int WINDOW_WIDTH = 1280;
	private static final int WINDOW_HEIGHT = 720; 
	
    public static void main(String[] args) {
        GUI _display = new GUI(args, WINDOW_WIDTH, WINDOW_HEIGHT);
        Schedule _schedule = new Schedule();
    }
}
