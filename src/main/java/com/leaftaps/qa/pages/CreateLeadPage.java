package com.leaftaps.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.leaftaps.qa.utility.ElementUtils;
import com.leaftaps.qa.utility.ExcelUtils;

public class CreateLeadPage 
{
	private WebDriver driver;
	private ElementUtils eU;
	public CreateLeadPage(WebDriver driver)
	{
		this.driver = driver;
		eU = new ElementUtils(driver);
		
	}
	private By CompanyName =By.xpath("//input[@id='createLeadForm_companyName']");
	private By FirstName = By.xpath("//input[@id='createLeadForm_firstName']");
	private By sourceDropdown = By.xpath("//select[@id='createLeadForm_dataSourceId']");
	
	public void doCreateLead(String CompanyName, String FirstName, String Source)
	{
		eU.doSend(this.CompanyName, CompanyName);
		eU.doSend(this.FirstName, FirstName);
		eU.selectByVisibleText(sourceDropdown, Source);
	}
	

}
