package calhacks;

import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ParseFromText {
    
    protected static HashMap<String, Department> _departmentMap;
    
    public static void run() throws FileNotFoundException {
        Scanner input = new Scanner(new File("calhacks/newtext.txt"));
        HashMap<String, Department> departmentMap = new HashMap<String, Department>();
        while (input.hasNextLine()) {
            String[] newline = input.nextLine().split(" @ ");
            HashMap<String, Course> courseMap = new HashMap<String, Course>();
            String name = newline[0];
            String rest = newline[1].substring(2, newline[1].length() - 2);
            String[] courses = rest.split("\\],\\ \\[");
            for (String c : courses) {
                Scanner temp = new Scanner(c);
                String courseNum = temp.next();
                courseNum = courseNum.substring(0, courseNum.length()-1);
                String courseTitle = "";
                String nextRead = temp.next();
                while (!nextRead.contains("}")) {
                    courseTitle += " " + nextRead;
                    nextRead = temp.next();
                }
                courseTitle += " " + nextRead;
                courseTitle = courseTitle.substring(2, courseTitle.length() - 2);
                String units = "";
                while (temp.hasNext()) {
                    units += " " + temp.next();
                }
                units = units.substring(1, units.length());
                Course _course = new Course(name, courseNum, courseTitle, units);
                courseMap.put(courseNum, _course);
            }
            Department d = new Department(name, courseMap);
            departmentMap.put(name, d);
        }
        input.close();
        _departmentMap = departmentMap;
    }
}
