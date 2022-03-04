package phase1allcodes;
import java.io.File;
import java.io.FileReader;

public class question21_read {
  public static void main(String[] args) {

    char[] array = new char[60];
    
    try {
  
      FileReader input = new FileReader("C://Users//Virendra//Desktop//Simplilearn//FSD_Phase_1//Prolim_Weeekday//phase1.txt");

   
      input.read(array);
      
      System.out.println("Data in the file:");
      System.out.println(array);

     
      input.close();
    }
    catch(Exception e) {
      e.getStackTrace();
    }
  }
}