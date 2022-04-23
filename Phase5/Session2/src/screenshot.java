import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class screenshot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driver_path= "D:\\Phase5\\chromedriver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",driver_path);
		
		///initiate the driver
		WebDriver driver= new ChromeDriver();
		driver.get ("http://www.facebook.com");
		///step:3 launching facebook
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File src=screenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File("D://ScreenShot//test1.png"));
		}catch (IOException e) {
			e.printStackTrace();
		}
		driver.close();
		
		}
		

	}


