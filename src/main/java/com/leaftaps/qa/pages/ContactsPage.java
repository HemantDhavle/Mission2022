package com.leaftaps.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.leaftaps.qa.utility.ElementUtils;

public class ContactsPage 
{
	private WebDriver driver;
	private ElementUtils eU;
	public ContactsPage(WebDriver driver)
	{
		this.driver = driver;
		eU = new ElementUtils(driver);
	}
	
	//private By contactMenu = By.xpath("//a[text()='Contacts']");
	private By contactHeader = By.xpath("//div[@id='sectionHeaderTitle_contacts']");
	private By fName = By.xpath("//a[text()='Hemant']");
	private By lName = By.xpath("(//a[text()='Hemant']/../../following-sibling::td)[1]//a");
	private By nextLink = By.xpath("//button[contains(@class,'page-next')]");
	
//	String fname = "//a[text()='Hemant']";
//	String lname = "(//a[text()='Hemant']/../../following-sibling::td)[1]//a";
//	String nextlink = "//button[contains(@class,'page-next')]";
//	
	
	public String validateContactPageTitle()
	{
		
		return eU.getElement(contactHeader).getText();
	}
	
//	public String validatePagination()
//	{
//		List<WebElement> firstN =  eU.getElements(fName);
//		
//		while(true)
//		{
//			if(!(firstN.size()==1))
//			{
//				eU.doClickWait(nextLink, 1000);
//				firstN =  eU.getElements(fName);
//			}
//			else
//			{
//				String lastName= eU.doGetTextWait(lName, 1000);
//				return lastName;
//			}
//		}
//	}
	
	
	public String getLastName()
	{
		return eU.validatePagination(fName,lName, nextLink );
	}
	

}
