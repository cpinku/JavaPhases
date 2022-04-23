package com.simplilearn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class googletitlecheck {

	public static void main(String[] args) {
		String path = "D:\\Phase5\\chromedriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);		
		WebDriver driver= new ChromeDriver();
		
		///step:2 base url
		
		String base_url= "http://www.google.com/";
		
		String expectedTitle="Google";
		String actualTitle="";
		
		///step:3 launching google chrome
		
		driver.get(base_url);
		
		actualTitle= driver.getTitle();
		
		if(actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Test Passes");
		}
		else {
			System.out.println("Test Failed");
		}
		
		//driver.close();
}

}
