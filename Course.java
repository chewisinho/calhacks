package calhacks;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.MatchResult;

/** Class representing a specific course.
 * @author S. Chewi
 */
public class Course implements Comparable<Course> {

    /** Constructor function which takes in the DEPARTMENT name, the
     * COURSEID, and the number of UNITS.
     */
    protected Course(String department, String courseID, String courseTitle, String units) {
        _department = department;
        _courseID = courseID;
        _courseTitle = courseTitle;
        Pattern unitCount = Pattern.compile("[1-5]");
        Matcher unitCountMatch = unitCount.matcher(units);
        if (!unitCountMatch.matches()) {
            _units = 1;
        }
        else {
            _units = Integer.parseInt(units);
        }
        Pattern p = Pattern.compile("([A-Z]?)([0-9]+)([A-Z]*)");
        Matcher m = p.matcher(courseID);
        if (m.find()) {
            if (m.group(1) != null) {
                _tag = m.group(1);
            }
            _courseNumber = Integer.parseInt(m.group(2));
            if (m.group(3) != null) {
                _courseSuffix = m.group(3);
            }
        }
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
    @Override
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
    private String _tag = "";
    /** The number of the course. */
    private int _courseNumber;
    /** The course suffix. */
    private String _courseSuffix = "";
    /** The course ID. */
    private String _courseID;
    /** The title of the course. */
    private String _courseTitle;
}
