package PHASE1Assesment;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Assesmentphase1 {
	public static void main(String[] args) throws IOException{
		String ch;
		String y;
		Scanner sc=new Scanner(System.in);
		System.out.println("****************************************************************************************\n");
		System.out.println("---------------------------------WELCOME ---------------------------------\n");
		System.out.println("****************************************************************************************\n");

		System.out.println("Options For Aplication are:");
		System.out.println("1.\t  File Names in Ascending Order:");
		System.out.println("2.\t Details of User Interface:");
		System.out.println("\t1)\t Add a file to a Existing Directory:");
		System.out.println("\t2)\t Delete a File From Existing Directory List:");
		System.out.println("\t3)\t Serach a File From Directory:");
		System.out.println("3.\t Close the Application:");
		ch=sc.nextLine();
		switch(ch)
		{
		case "1":
			try{
				File fin=new File("C://Users//Lenovo//Desktop//Assisted Practise");
				File[] listOfFiles = fin.listFiles();

				for (int i = 0; i < listOfFiles.length; i++) {
				  if (listOfFiles[i].isFile())
				  {
				    System.out.println("File " + listOfFiles[i].getName());
				  } else if (listOfFiles[i].isDirectory())
				  {System.out.println("Directory " + listOfFiles[i].getName());}
				}
				}
				catch(Exception e)
				{
					System.out.println("Folder Do Not Exits");
				}
			break;
		case "2.1":
			createFileUsingFileClass();
			break;
		case "2.2":
			try
	        { 
	            Files.deleteIfExists(Paths.get("C://Users//Lenovo//Desktop//Assisted PractisetestFile3.txt")); 
	        } 
	        catch(NoSuchFileException e) 
	        { 
	            System.out.println("No such file/directory exists"); 
	        } 
	        catch(DirectoryNotEmptyException e) 
	        { 
	            System.out.println("Directory is not empty."); 
	        } 
	        catch(IOException e) 
	        { 
	            System.out.println("Invalid permissions."); 
	        } 
	          
	        System.out.println("Deletion successful.");
	        break;
		case "2.3":
		      File directory = new File("C://Users//Lenovo//Desktop//Assisted Practise");

		        MyFilenameFilter filter= new MyFilenameFilter("testFile1.txt");
		        String[] flist = directory.list(filter);
		  
		        // Empty array
		        if (flist == null) {
		            System.out.println(
		                "Empty directory or directory does not exists.");
		        }
		        else {

		            for (int i = 0; i < flist.length; i++) {
		                System.out.println(flist[i]+" found");
		            }
		        }
		        break;
		case "3":
			System.exit(0);
	    default:
	    	System.out.println("Invalid Option Try again!!");
		
		}
	}
	
    private static void createFileUsingFileClass() throws IOException
    {
          File file = new File("C://Users//Lenovo//Desktop//Assisted Practise//testFile3.txt");
  
          //Create the file
          if (file.createNewFile()){
            System.out.println("File is created!");
          }else{
            System.out.println("File already exists.");
          }
           
          //Write Content
          FileWriter writer = new FileWriter(file);
          writer.write("Test data");
          writer.close();
    }	
}
class MyFilenameFilter implements FilenameFilter {
    
    String initials;
    public MyFilenameFilter(String initials)
    {
        this.initials = initials;
    }
    
    public boolean accept(File dir, String name)
    {
        return name.startsWith(initials);
    }
}
