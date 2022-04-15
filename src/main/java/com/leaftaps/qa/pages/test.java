package com.leaftaps.qa.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class test 
{
	
	private final String path = "";
	public Workbook book;
	public Sheet sheet;
	public static WebDriver driver;
	public void windowHandle()
	{
		 Set<String>  handles = driver.getWindowHandles();
		 Iterator<String> it = handles.iterator();
		 String parentId= it.next();
		 String childId= it.next();
		 driver.switchTo().window(childId);
		 driver.switchTo().window(parentId);
	}
	
	public void screenshot()
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"screenshot";
		File des = new File(path);
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public String excel(String sheetName)
	{
		Object[][] data=null;
		try {
			FileInputStream fs = new FileInputStream(path);
		
				book = WorkbookFactory.create(fs);
				sheet =	book.getSheet(sheetName);
			} catch (InvalidFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		int row  = sheet.getLastRowNum();
		int col = sheet.getRow(0).getLastCellNum();
		data = new Object[row][col]; 
		for(int i = 0;i<row; i++)
		{
			for (int j = 0 ;j< col ; j++)
			{
			data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		
		}
		return sheetName; 
		
	}
	@Test(invocationCount =2)
	public void explicitwait(int interval)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(interval));
		wait.until(ExpectedConditions.visibilityOfAllElements());
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(interval));
		
	}
	
}
