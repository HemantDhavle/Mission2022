package com.leaftaps.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.leaftaps.qa.utility.Constants;
import com.leaftaps.qa.utility.ElementUtils;
import com.leaftaps.qa.utility.JavaScriptUtils;

public class LoginPage 
{
	private WebDriver driver;
	private ElementUtils eU;
	private JavaScriptUtils jU;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		eU = new ElementUtils(driver);
		jU = new JavaScriptUtils(driver);
		
	}
	
	private By userName = By.xpath("//input[@id='username']");
	private By password = By.xpath("//input[@id='password']");
	private By loginbuton = By.xpath("//input[@class='decorativeSubmit' and @type ='submit']");
	
	public String LoginPageTitle()
	{
		return eU.doGetTitle();
	
	}
	
	public String LoginPageURL()
	{
		return eU.doGetURL();
		
	}
	
	public DashboardPage doLogin(String uname, String pword)
	{
		eU.doSend(userName, uname);
		eU.doSend(password, pword);
		eU.doClick(loginbuton);
		return new DashboardPage(driver);
	}
}
