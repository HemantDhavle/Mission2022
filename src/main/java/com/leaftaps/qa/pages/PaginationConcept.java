package com.leaftaps.qa.pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PaginationConcept 
{
	public static WebDriver driver;
	
	
	public  static void main(String args[]) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--incognito");
		driver = new ChromeDriver(co);
		driver.get("http://www.babynames.merschat.com/popular.cgi");
		
		By getNext = By.xpath("(//a[text()=' Ravi ']/../parent::td/following-sibling::td)[1]//td[1]//a");
		List<WebElement> name = driver.findElements(By.xpath("//a[contains(text(),'Ravi')]"));
		
		while(true)
		{
			if(!(name.size() == 1))
			{
				driver.findElement(By.xpath("//font[text()='Next']")).click();
				name = driver.findElements(By.xpath("//a[contains(text(),'Ravi')]"));
			}
			else
			{
				String gender = driver.findElement(getNext).getAttribute("title");
				System.out.println(gender);
				break;
			}
		}
	}

}
