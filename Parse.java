import java.util.*;
import java.io.IOException;

/*@author Alexander Tran
October 9, 2015
Parses the source code from DownloadPage.java to get the specific date. */

public class Parse {
	public static void main(String[] args) throws IOException {
		DownloadPage.sourceCodeGen();
		String input = DownloadPage.getSourceCode();
		System.out.println(input);
		Parse.classlist = createArray(input);
		for (int i = 0; i < Parse.classlist.size(); i++) {
			System.out.println(Parse.classlist.get(i)); 
		}
	}

	public static ArrayList<String> createArray(String input){
		ArrayList<String> L = new ArrayList<String>();
        Scanner s = new Scanner(input);
        for (int classnumber = 0; s.hasNext(); classnumber++, s.next()) {
            L.add("class " + classnumber);
        }
        return L;
	}

	private static ArrayList<String> classlist;
}
