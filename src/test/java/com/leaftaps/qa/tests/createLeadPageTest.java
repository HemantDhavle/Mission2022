package com.leaftaps.qa.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.leaftaps.qa.listeners.TestAllureListener;
import com.leaftaps.qa.utility.Constants;
import com.leaftaps.qa.utility.ExcelUtils;

@Listeners(TestAllureListener.class)
public class createLeadPageTest extends BaseTest
{
	
	@BeforeClass
	public void setupRegistration() 
	{
		dashboardPage = loginPage.doLogin(prop.getProperty("un"), prop.getProperty("pw"));
		homePage= dashboardPage.doDashboardIconClick();
		createLead = homePage.ClickCreateLeadbutton();
	}
	
	@DataProvider
	public Object[][] getLeadData()
	{
		return ExcelUtils.getExcelData(Constants.EXCEL_SHEET_NAME);
		
	}
	
	
	@Test(dataProvider = "getLeadData")
	public void doCreateLeadTest(String CompanyName, String FirstName, String Source)
	{
		createLead.doCreateLead(CompanyName, FirstName, Source);
		System.out.println("This is doCreateLeadTests");
	}
	
	
	
	

}
