package com.qa.otherpractise;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowHandle {

	public static WebDriver driver;
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		WebElement imageLink = driver.findElement(By.xpath("//a[text()='Images']"));
		imageLink.sendKeys(Keys.chord(Keys.CONTROL,Keys.RETURN));
		
		ArrayList<String> window = new ArrayList<String>(driver.getWindowHandles());
			
		
	}

}
