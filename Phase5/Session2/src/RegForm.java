import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegForm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path= "D:\\Phase5\\chromedriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",path);
        
        ///initiate the driver
        WebDriver driver= new ChromeDriver();
        ///step:2 base url
        String base_url= "https://www.shine.com/registration/";
        ///step:3 launching shine.com
        driver.get(base_url);
        
        
        WebElement check= driver.findElement(By.id("id_privacy"));
        
        WebElement name= driver.findElement(By.id("id_name"));
        name.sendKeys("Sunny");
        
        WebElement email= driver.findElement(By.id("id_email"));
        email.sendKeys("sunny@gmail.com");
        
        WebElement pass= driver.findElement(By.id("id_password"));
        pass.sendKeys("Sunny@1234");
        
        WebElement mobile= driver.findElement(By.id("id_cell_phone"));
        mobile.sendKeys("9876543210");
        
        WebElement button= driver.findElement(By.id("registerButton"));
        button.click();

	}

}
