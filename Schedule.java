package calhacks;

import java.util.ArrayList;

/** A schedule which contains terms and methods to add/remove classes.
 * @author S. Chewi
 */
public class Schedule {
    
    /** Used for testing purposes only. */
    public static void main(String[] args) {
        
    }

    /** Constructor that initializes a blank schedule. */
    protected Schedule() {
        for (int i = 0; i < NUM_YEARS * NUM_TERMS; i += 1) {
            terms.add(new Term());
        }
    }

    /** Adds COURSE to the requested TERM. */
    public void add(Course course, int term) {
        terms.get(term).add(course);
    }
    
    /** Clears the requested TERM of all classes. */
    public void clear(int term) {
        terms.get(term).clear();
    }

    /** Returns the total number of units taken. */
    public int totalUnits() {
        int unit = 0;
        for (Term t : terms) {
            unit += t.units();
        }
        return unit;
    }

    /** Contains a list of terms. */
    private final ArrayList<Term> terms =
            new ArrayList<Term>(NUM_YEARS * NUM_TERMS);
    /** The number of years of school. */
    private static final int NUM_YEARS = 4;
    /** The number of terms per year. */
    private static final int NUM_TERMS = 3;
}
