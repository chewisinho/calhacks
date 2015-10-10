
import java.lang.String;
import java.util.*;
import java.io.IOException;
import java.util.regex.*;

/*@author Alexander Tran
October 9, 2015
Parses the source code from DownloadPage.java to get the specific date. */

public class Parse {
	public static void main(String[] args) throws IOException {
		DownloadPage.sourceCodeGen();
		String input = DownloadPage.getSourceCode();

		System.out.println(makeTestList());

		Parse.classlist = createArray(input);
		System.out.println(Parse.classlist);
	}
	public static ArrayList<ArrayList<String>> makeTestList() {
		ArrayList<ArrayList<String>> L = new ArrayList<ArrayList<String>>();
		ArrayList<String> L1 = new ArrayList<String>();
		
		L1.add("hi");
		L.add(L1);
		return L;
	}

	// expression = "class="courseblocktitle"><a"

	public static ArrayList<ArrayList<String>> createArray(String input){
		ArrayList<ArrayList<String>> L = new ArrayList<ArrayList<String>>();
        Scanner s = new Scanner(input);
        while (s.hasNext()) {
        	String elem = s.next();
            if (elem.contains("courseblocktitle")) {
            	ArrayList<String> temp = new ArrayList<String>();
            	// adds Course Number
            	s.next();
            	String coursenumber = s.next();
            	coursenumber = coursenumber.substring(0, coursenumber.length() - 1);
            	temp.add(coursenumber);
            	for (int i = 0; i < 5; i++){
            		s.next();
            	}
            	// adds Course Title
            	String elem2 = s.next();
            	String coursetitle = "";
            	while (!elem2.contains("<")) {
            		coursetitle += " " + elem2;
            		elem2 = s.next();
            	}
            	coursetitle += " " + elem2;
            	coursetitle = coursetitle.substring(15, coursetitle.length()-7);
        		temp.add(coursetitle);
        		// adds Course Units
        		s.next();
        		String courseunits = "";
        		String elem3 = s.next();
        		while (!elem3.contains("<")) {
        			courseunits += " " + elem3;
        			elem3 = s.next();
        		}
        		courseunits = courseunits.substring(15);
        		temp.add(courseunits);
            	L.add(temp);
            }
        }
        return L;
	}

	private static ArrayList<ArrayList<String>> classlist;

	public static ArrayList<ArrayList<String>> getClassList() {
		return Parse.classlist;
	}
}
