package com.leaftaps.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.leaftaps.qa.listeners.TestAllureListener;
import com.leaftaps.qa.utility.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Epic ("This is EPIC Login")
@Story("ABCD")
@Listeners(TestAllureListener.class)
public class loginPageTest extends BaseTest 
{
	@Description("This method is to check login page title")
	@Test(enabled =false)
	public void LoginPageTitleTest()
	{
		String loginTitle = loginPage.LoginPageTitle();
		Assert.assertEquals(loginTitle, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Severity(SeverityLevel.MINOR)
	@Test(invocationCount = 2)
	public void LoginPageURLTest()
	{
		String loginURL = loginPage.LoginPageURL();
		Assert.assertEquals(loginURL, Constants.LOGIN_PAGE_URL);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void doLoginTest()
	{
		loginPage.doLogin(prop.getProperty("un"), prop.getProperty("pw"));
	}
}
