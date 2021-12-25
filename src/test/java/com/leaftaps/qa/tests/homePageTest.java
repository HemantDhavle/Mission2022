package com.leaftaps.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.leaftaps.qa.pages.HomePage;

public class homePageTest extends BaseTest
{
	public HomePage homePage;
	@BeforeClass
	public void setupRegistration() 
	{
		dashboardPage = loginPage.doLogin(prop.getProperty("un"), prop.getProperty("pw"));
		homePage= dashboardPage.doDashboardIconClick();
	}
	
	@Test
	public void CreateLeadLinkDisplayedTest()
	{
		boolean linkpresent= homePage.CreateLeadLinkDisplayed();
		Assert.assertTrue(linkpresent);
	}
	
	@Test
	public void ClickCreateLeadbuttonTest()
	{
		homePage.ClickCreateLeadbutton();
		
		
	}
	
	

}
