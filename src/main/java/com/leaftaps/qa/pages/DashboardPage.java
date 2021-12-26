package com.leaftaps.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.leaftaps.qa.utility.ElementUtils;
import com.leaftaps.qa.utility.JavaScriptUtils;

public class DashboardPage 
{
	private WebDriver driver;
	private ElementUtils eU;
	private JavaScriptUtils jU;
	public DashboardPage(WebDriver driver)
	{
		this.driver = driver;
		eU = new ElementUtils(driver);
		jU = new JavaScriptUtils(driver);
		
	}
	
	private By dashboardHeader = By.xpath("//div[@id='form']/h2/text()[preceding-sibling::br]");
	private By dashboardButton = By.xpath("//div[@class='crmsfa']/a");
	
	
	public String dashboardPageTitle()
	{
		return jU.doJSgetTitle();
	}
	
//	public String dashboardPageHeader()
//	{
//		String el = eU.getElement(dashboardHeader).getText().trim();
//		System.out.println("text is" +el);
//		return el;
//		
//	}
		
	public HomePage doDashboardIconClick()
	{
		eU.doClick(dashboardButton);
		return new HomePage(driver);
	}


}
