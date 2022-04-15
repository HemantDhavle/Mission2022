package com.leaftaps.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.leaftaps.qa.pages.ContactsPage;
import com.leaftaps.qa.pages.HomePage;
import com.leaftaps.qa.utility.Constants;

public class contactPageTest extends BaseTest
{
	public HomePage homePage;
	public ContactsPage contactPage;
	@BeforeClass
	public void setupRegistration() 
	{
		dashboardPage = loginPage.doLogin(prop.getProperty("un"), prop.getProperty("pw"));
		homePage= dashboardPage.doDashboardIconClick();
		contactPage = homePage.ClickContactbutton();
	}
	
	
	@Test
	public void validateContactPageTitleTest()
	{
		String contactTitle = contactPage.validateContactPageTitle();
		Assert.assertEquals(contactTitle.trim(), Constants.CONTACT_PAGE_TITLE);
	}
	
	@Test
	public void validatePagination()
	{
		String lastName = contactPage.getLastName();
		Assert.assertEquals(lastName, "Dhavle1");
	}

}
