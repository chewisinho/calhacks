package calhacks;


public class TestPrint {
   public static void main(String[] args) throws java.io.IOException {
      Parse.run();
      System.out.print(Parse.getClassList());
   }
}
