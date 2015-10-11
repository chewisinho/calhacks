package calhacks;

import java.util.ArrayList;
import java.io.IOException;

public class SinhoPrintTest {
    
    public static void main(String[] args) throws IOException  {
        Parse.run();
        System.out.print(Parse.getClassList());
    }
    
}
