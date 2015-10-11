
import java.lang.String;
import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.*;
import java.net.URL;
import java.net.URLConnection;

/*@author Alexander Tran
October 9, 2015
Parses the source code from DownloadPage.java to get the specific date. */

public class Parse {
    
	public static void main(String[] args) throws IOException {
        departments = makeDepartments();
        String url;
        for (int i = 0; i < departments.size(); i++) {
            for (int j = 0; j < departments.size(); j++) {
                Department caldepartment = new Department(departments.get(j));
                Parse.classlist.add(caldepartment);
            }
        }   
	}

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

	private static ArrayList<Department> classlist;

    private static ArrayList<String> departments;

    public static ArrayList<Department> getClassList() {
        return Parse.classlist;
    }

    public static ArrayList<String> getDepartments() {
        return Parse.departments;
    }


    public static String makeConnectionToCourses() throws IOException {
        URL url = new URL("http://guide.berkeley.edu/courses/");
        URLConnection con = url.openConnection();
        InputStream is = con.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = null;
        String source = "";
        while ((line = br.readLine()) != null) {
           source += line;
        }
        return source;
    }

    public static ArrayList<String> makeDepartments() throws IOException {
        ArrayList<String> L = new ArrayList<String>();
        String source = makeConnectionToCourses();
        Scanner s = new Scanner(source);
        String temp;
        while (s.hasNext()) {
            String elem = s.next();
            if (elem.contains("courses")) {
                L.add(elem);
            }
        }
        for (int i = 0; i < 3; i++) {
            L.remove(0);
        }
        L.remove(L.size() - 1);
        L.remove(L.size() - 1);
        int deleteindex = 0;
        for (int j = 0; j < L.size(); j++) {
            L.set(j,L.get(j).substring(15));
            deleteindex = L.get(j).indexOf("/");
            L.set(j,L.get(j).substring(0, deleteindex));
        }
        return L;
    }    

}


