package calhacks;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

/** Text-based display designed to support only one schedule.
 * @author S. Chewi
 */
public class TextDisplay {
    
    /** Constructor which takes in a SCHEDULE. */
    protected TextDisplay(Schedule schedule) {
        _schedule = schedule;
    }
    
    /** Initializes and sets up the text display. */
    public void run() throws IOException {
        Parse.run();
        while (true) {
            display();
            String line = getCommand();
            if (line == null) {
                break;
            }
            Scanner input = new Scanner(line);
            switch (input.next().toLowerCase()) {
            case "add":
                String courseNumber = input.next();
                int term = Integer.parseInt(input.next());
                for (ArrayList<String> _course : Parse.getClassList()) {
                    if (_course.get(0).equals(courseNumber)) {
                        Course course = new Course("STAT", courseNumber, _course.get(2));
                        _schedule.add(course, term);
                        break;
                    }
                }
                break;
            case "clear":
                int _term = Integer.parseInt(input.next());
                _schedule.clear(_term);
                break;
            case "units":
                System.out.println(_schedule.totalUnits());
                break;
            default:
                throw new IllegalArgumentException("Unknown command!");
            }
        }
    }
    
    /** Returns the next command from the command line. */
    private String getCommand() {
        while (true) {
            System.err.print("> ");
            System.err.flush();
            if (!_input.hasNext()) {
                break;
            }
            String line = _input.nextLine();
            line = line.trim();
            if (!line.startsWith("#") && !line.isEmpty()) {
                return line;
            }
        }
        return null;
    }
    
    /** Displays a text representation of the schedule. */
    public void display() {
        for (int i = 0;
                i < Schedule.NUM_YEARS * Schedule.NUM_TERMS; i += 1) {
            Term t = _schedule.getTerm(i);
            System.out.print(i + ": ");
            System.out.print(t);
            System.out.println();
        }
    }
    
    /** The current schedule. */
    private final Schedule _schedule;
    /** Takes in user input. */
    private Scanner _input = new Scanner(System.in);
}
