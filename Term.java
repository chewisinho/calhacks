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

    /** The maximum number of classes taken per term. */
    public static final int MAX_CLASSES = 5;
    /** Contains a list of the classes in the term. */
    protected final ArrayList<Course> courses =
            new ArrayList<Course>(MAX_CLASSES);
}
