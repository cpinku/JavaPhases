package com.simplilearn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class firstdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path= "D:\\Phase5\\chromedriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",path);
        
        
        WebDriver driver= new ChromeDriver();
        
        String base_url= "http://www.google.com/";
        
        driver.get(base_url);
        
        //driver.close();

	}

}
