package calhacks;

import java.net.URL;
import java.net.URLConnection;
import java.util.*; 
import java.io.IOException;

public class Department {
	/** Name of department. */
	public String _name;

	public ArrayList<ArrayList<String>> courses;

	public Department(String name) throws IOException {
		_name = name;
		String url = "http://guide.berkeley.edu/courses/" + name + "/";
        URL links = new URL(url);
        DownloadPage.sourceCodeGen(links);
        String input = DownloadPage.getSourceCode();
        courses = Parse.createArray(input);
	}
}