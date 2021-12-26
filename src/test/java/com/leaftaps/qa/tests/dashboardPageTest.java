package com.leaftaps.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.leaftaps.qa.utility.Constants;

public class dashboardPageTest extends BaseTest 
{
	@BeforeClass
	public void doLogin()
	{
		dashboardPage = loginPage.doLogin(prop.getProperty("un"), prop.getProperty("pw"));
	}
	
	@Test
	public void dashboardPageTitleTest()
	{
		String dashboardTitle = dashboardPage.dashboardPageTitle();
		Assert.assertEquals(dashboardTitle, Constants.DASHBOARD_PAGE_TITLE);
	}
//	
//	@Test
//	public void dashboardPageHeaderTest()
//	{
//		String dashboardHeader = dashboardPage.dashboardPageHeader();
//		System.out.println(dashboardHeader);
//		//Assert.assertEquals(dashboardHeader, Constants.DASHBOARD_PAGE_HEADER);
//	}
	
	@Test
	public void doDashboardIconClickTest()
	{
		dashboardPage.doDashboardIconClick();
	}
	
	

}
