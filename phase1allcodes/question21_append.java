package phase1allcodes;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class question21_append {

	
	public static void main(String[] args) {
		String filePath = "/Users/pankaj/Downloads/append.txt";

		String appendText = "This String will be appended to the file, Byte=0x0A 0xFF";

		appendUsingFileWriter(filePath, appendText);

		appendUsingBufferedWriter(filePath, appendText, 2);

		appendUsingPrintWriter(filePath, appendText);

		appendUsingFileOutputStream(filePath, appendText);
	}

	private static void appendUsingPrintWriter(String filePath, String text) {
		File file = new File(filePath);
		FileWriter fr = null;
		BufferedWriter br = null;
		PrintWriter pr = null;
		try {
			// to append to file, you need to initialize FileWriter using below constructor
			fr = new FileWriter(file, true);
			br = new BufferedWriter(fr);
			pr = new PrintWriter(br);
			pr.println(text);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				pr.close();
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
	private static void appendUsingFileOutputStream(String fileName, String data) {
		OutputStream os = null;
		try {
		
			os = new FileOutputStream(new File(fileName), true);
			os.write(data.getBytes(), 0, data.length());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
	private static void appendUsingBufferedWriter(String filePath, String text, int noOfLines) {
		File file = new File(filePath);
		FileWriter fr = null;
		BufferedWriter br = null;
		try {
			
			fr = new FileWriter(file, true);
			br = new BufferedWriter(fr);
			for (int i = 0; i < noOfLines; i++) {
				br.newLine();
				
				br.write(text);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
	 
	private static void appendUsingFileWriter(String filePath, String text) {
		File file = new File(filePath);
		FileWriter fr = null;
		try {
			
			fr = new FileWriter(file, true);
			fr.write(text);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
	

