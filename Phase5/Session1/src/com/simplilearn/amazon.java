package com.simplilearn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class amazon {

	public static void main(String[] args) {
		
        String path = "D:\\Phase5\\chromedriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        
        WebDriver driver = new ChromeDriver();
    
        String base_url = "https://www.amazon.in/";
        String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        String actualTitle = "";
        
        driver.get(base_url);
        actualTitle = driver.getTitle();
        if (actualTitle.contentEquals(expectedTitle)) {
            System.out.println("Test Passes");
        } else {
            System.out.println("Test Failed");
        }
	}
}
// driver.close();