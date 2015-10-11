package calhacks;
//skeleton from Stack Overflow
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/*Data File
@author Alexander Tran
October 9, 2015
Gets source code from a website for the use of CalHacks 2.0 program. */

public class DownloadPage {

    public static void sourceCodeGen(URL url) throws IOException {
        // Get the input stream through URL Connection
        URLConnection con = url.openConnection();
        InputStream is = con.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = null;
        while ((line = br.readLine()) != null) {
            DownloadPage.sourcecode += line;
        }
    }

    /* String that is the sourcode. */
    private static String sourcecode;

    public static String getSourceCode() {
        return DownloadPage.sourcecode;
    }

}
