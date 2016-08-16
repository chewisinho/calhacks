/*
 * Filewriter
 */
package calhacks;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class DataWriter<T> {

   private String _path;
   private ArrayList<T> arrList;
   private T[] _arr;

   private BufferedWriter writer;

   public DataWriter(ArrayList<T> arr, String path) {
      _path = path;
      arrList = arr;
   }

   public DataWriter(T[] arr, String path) {
      _path = path;
      _arr = arr;
   }

   public void write() {
      System.out.println("Writing to " + _path);
      try {
      File file = new File(_path);

      if (!file.exists()) file.createNewFile();

      writer = new BufferedWriter(new FileWriter(file.getAbsoluteFile())); 

      for (T t : _arr) {
         writer.write(t.toString());
         System.out.println(t.toString());
         writer.newLine();
      }

      writer.close();

      } catch (FileNotFoundException e) {
         System.out.println("File not found");
      } catch (IOException ioe) {
         System.out.println("woops");   
      }
   }
}
