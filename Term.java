package calhacks;

import java.util.ArrayList;

/** Representation of a particular semester or quarter.
 * @author S. Chewi
 */
public class Term {

    /** Adds COURSE to the list of courses. */
    protected void add(Course course) {
        if (courses.size() >= MAX_CLASSES) {
            throw new IllegalStateException();
        }
        courses.add(course);
        courses.sort(null);
    }

    /** Returns the total number of units in the term. */
    public int units() {
        int unit = 0;
        for (Course c : courses) {
            unit += c.getUnits();
        }
        return unit;
    }
    
    /** Clears the current term of all classes. */
    protected void clear() {
        courses.clear();
    }
    
    /** Returns a string representation of the courses. */
    @Override
    public String toString() {
        String result = "";
        for (Course c : courses) {
            result = result + c.getCourseName() + " | ";
        }
        return result;
    }
    
    public static int getTermNumber(String term) {
        String[] _terms = {"1st Year Fall", "1st Year Spring", "1st Year Summer",
                "2nd Year Fall", "2nd Year Spring", "2nd Year Summer",
                "3rd Year Fall", "3rd Year Spring", "3rd Year Summer",
                "4th Year Fall", "4th Year Spring", "4th Year Summer"};
        int termNumber = 0;
        for (int i = 0; i < _terms.length; i += 1) {
            if (term.equals(_terms[i])) {
                termNumber = i;
                break;
            }
        }
        return termNumber;
    }

    /** The maximum number of classes taken per term. */
    public static final int MAX_CLASSES = 5;
    /** Contains a list of the classes in the term. */
    protected final ArrayList<Course> courses =
            new ArrayList<Course>(MAX_CLASSES);
}
