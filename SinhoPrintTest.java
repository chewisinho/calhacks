package calhacks;

import java.util.ArrayList;
import java.io.IOException;

public class SinhoPrintTest {
    
    public static void main(String[] args) throws IOException  {
        Parse.run();
        for (Department d : Parse.getClassList()) {
            System.out.println(d);
        }
    }
    
}
