package com.leaftaps.qa.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.leaftaps.qa.factory.DriverFactory;
import com.leaftaps.qa.pages.CreateLeadPage;
import com.leaftaps.qa.pages.DashboardPage;
import com.leaftaps.qa.pages.HomePage;
import com.leaftaps.qa.pages.LoginPage;

public class BaseTest 
{
	public DriverFactory df;
	public Properties prop;
	public WebDriver driver;
	public LoginPage loginPage;
	public DashboardPage dashboardPage;
	public HomePage homePage;
	public CreateLeadPage createLead;
	
	@BeforeTest
	public void setUp()
	{
		df = new DriverFactory();
		prop = df.initilized_prop();
		driver  = df.initilized_driver(prop);
		loginPage = new LoginPage(driver);
		//dashboardPage = new DashboardPage(driver);
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
