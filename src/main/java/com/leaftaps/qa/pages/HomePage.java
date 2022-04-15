package com.leaftaps.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.leaftaps.qa.utility.ElementUtils;

public class HomePage 
{
	private WebDriver driver;
	private ElementUtils eU;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		eU = new ElementUtils(driver);
	}
	
	private By createLeadLink = By.xpath("//ul[@class = 'shortcuts']//a[contains(text(),'Lead')]");
	private By contactMenu = By.xpath("//a[text()='Contacts']");
	
	public boolean CreateLeadLinkDisplayed()
	{
		return eU.doElementDisplayedWait(createLeadLink, 2);
	}
	
	public CreateLeadPage ClickCreateLeadbutton()
	{
		eU.doClick(createLeadLink);
		return new CreateLeadPage(driver);
	}

	
	public ContactsPage ClickContactbutton()
	{
		eU.doClick(contactMenu);
		return new ContactsPage(driver);
	}

}
