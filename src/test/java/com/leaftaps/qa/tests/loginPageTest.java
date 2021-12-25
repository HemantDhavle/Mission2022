package com.leaftaps.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.leaftaps.qa.utility.Constants;

public class loginPageTest extends BaseTest 
{
	@Test
	public void LoginPageTitleTest()
	{
		String loginTitle = loginPage.LoginPageTitle();
		Assert.assertEquals(loginTitle, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test
	public void LoginPageURLTest()
	{
		String loginURL = loginPage.LoginPageURL();
		Assert.assertEquals(loginURL, Constants.LOGIN_PAGE_URL);
	}

	@Test
	public void doLoginTest()
	{
		loginPage.doLogin(prop.getProperty("un"), prop.getProperty("pw"));
	}
}
