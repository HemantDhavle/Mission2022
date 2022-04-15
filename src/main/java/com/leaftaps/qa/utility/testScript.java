package com.leaftaps.qa.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class testScript 
{
	private WebDriver driver;
	
	public testScript()
	{
		this.driver= driver;
		
	}
	
	public void sendKey(String val)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById='"+ val +"'");
		
	}

}
