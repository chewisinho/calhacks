package calhacks;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/** Class representing a specific course.
 * @author S. Chewi
 */
public class Course implements Comparable<Course> {

    /** Constructor function which takes in the DEPARTMENT name, the
     * COURSEID, and the number of UNITS.
     */
    protected Course(String department, String courseID, int units) {
        _department = department;
        _courseID = courseID;
        Pattern p = Pattern.compile("([A-Z]?)([0-9]+)([A-Z]*)");
        Matcher m = p.matcher(courseID);
        _tag = m.group(0);
        _courseNumber = Integer.parseInt(m.group(1));
        _courseSuffix = m.group(2);
    }

    /** Returns the units of the course. */
    public int getUnits() {
        return _units;
    }

    /** Returns the name of the course. */
    public String getCourseName() {
        return _department + " " + _tag + _courseNumber + _courseSuffix;
    }

    /** Returns the department name. */
    public String getDepartment() {
        return _department;
    }

    /** Returns the course number. */
    public int getCourseNumber() {
        return _courseNumber;
    }

    /** Returns an alphabetical ordering by course title against C. */
    public int compareTo(Course c) {
        if (_department != c.getDepartment()) {
            return _department.compareToIgnoreCase(c.getDepartment());
        } else if (_courseNumber != c.getCourseNumber()) {
            return _courseNumber - c.getCourseNumber();
        } else {
            return getCourseName().compareToIgnoreCase(c.getCourseName());
        }
    }

    /** Number of units of the course. */
    private int _units;
    /** Name of the department offering the course. */
    private String _department;
    /** Contains any tag that the course has. */
    private String _tag;
    /** The number of the course. */
    private int _courseNumber;
    /** The course suffix. */
    private String _courseSuffix;
    /** The course ID. */
    private String _courseID;
}
