package phase1allcodes;

import java.io.File;
import java.io.FileWriter;

public class question21_write {
  public static void main(String args[]) {

    String data = "This is the data in the output file";
    
    try {
      // Step 1: Creates a Writer using FileWriter
      FileWriter output = new FileWriter("C://Users//Virendra//Desktop//Simplilearn//FSD_Phase_1//Prolim_Weeekday//phase1.txt");

     
      output.write(data);
      System.out.println("Data is written to the file.");

      
      output.close();
    }
    catch (Exception e) {
      e.getStackTrace();
    }
 }
}