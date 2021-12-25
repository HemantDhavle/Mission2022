package com.leaftaps.qa.utility;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils 
{
	public WebDriver driver;
	public WebDriverWait wait;
	
	public ElementUtils(WebDriver driver)
	{ 
		this.driver= driver;
	}
	
	public By getBy(String locatorType, String locatorValue) 
	{
		By locator = null;
		
		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(locatorValue);
			break;
		case "name":
			locator = By.name(locatorValue);
			break;
		case "className":
			locator = By.className(locatorValue);
			break;
		case "xpath":
			locator = By.xpath(locatorValue);
			break;
		case "cssselector":
			locator = By.cssSelector(locatorValue);
			break;
		case "linktext":
			locator = By.linkText(locatorValue);
			break;
		case "partiallinktext":
			locator = By.partialLinkText(locatorValue);
			break;
		default:
			System.out.println("Please pass the correct locator"+ locatorType);
			break;	
		}
		return locator;
	}
	//get the element
	public WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	
	public WebElement getElement(String locatorType, String locatorValue)
	{
		return driver.findElement(getBy(locatorType, locatorValue));
	}
	
	//get the elements
	public List<WebElement> getElements(By locator)
	{
		return driver.findElements(locator);
	}
	
	public List<WebElement> getElements(String locatorType, String locatorValue)
	{
		return driver.findElements(getBy(locatorType, locatorValue));
	}
	
	
	
	public List<String> getElementsList(String locatorType, String locatorValue)
	{
		 List<WebElement> list = driver.findElements(getBy(locatorType, locatorValue));
		 List<String> elementList = null;
		 for(WebElement e :list)
		 {
			 String text= e.getText();
			 elementList.add(text);
		 }
		 return elementList;
		 
	}
	
	//get title of the page
	public String doGetTitle()
	{
		return driver.getTitle();
	}
	
	//get currentPage URL
	public String doGetURL()
	{
		return driver.getCurrentUrl();
	}
	
	//enter value inside the textbox
	public void doSend(By locator, String value)
	{
		getElement(locator).sendKeys(value);
	}
	
	//click on the button
	public void doClick(By locator)
	{
		getElement(locator).click();
	}
	
	//browserActions
	public void goBack()
	{
		driver.navigate().back();
	}
	
	public void goForward()
	{
		driver.navigate().forward();
	}
	
	public void doRefresh()
	{
		driver.navigate().refresh();
	}
	
	//select value from Select type drop down
	public Select doSelectDropdown(By locator)
	{
		Select sel = new Select( getElement(locator));
		return sel;
	}
	
	public void selectByValue(By locator, String value)
	{
		doSelectDropdown(locator).selectByValue(value);
	}
	
	public void selectByValue(By locator, int index)
	{
		doSelectDropdown(locator).selectByIndex(index);
	}
	
	public void selectByVisibleText(By locator, String text)
	{
		doSelectDropdown(locator).selectByVisibleText(text);
	}
	
	public void selectOptionFromSelectDropDown(By locator, String option)
	{
		List<WebElement> selectOptions = doSelectDropdown(locator).getOptions();
		for(WebElement e : selectOptions)
		{
			if(e.getText().equalsIgnoreCase(option))
			{
				e.click();
				break;
			}
		}
	}
	
	//Synchronizations
	public void doClickWait(By locator, int duration)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.visibilityOf(getElement(locator))).click();
	}
	
	public void doClickWait(By locator, int duration, long interval)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(duration, interval));
		wait.until(ExpectedConditions.visibilityOf(getElement(locator))).click();
	}

	
	public void doSendWait(By locator, int duration, String value)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.visibilityOf(getElement(locator))).sendKeys(value);
	}
	
	public void doSendWait(By locator, int duration, String value, long interval)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(duration, interval));
		wait.until(ExpectedConditions.visibilityOf(getElement(locator))).sendKeys(value);
	}
	
	
	public Boolean doElementDisplayedWait(By locator, int duration)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		return wait.until(ExpectedConditions.visibilityOf(getElement(locator))).isDisplayed();
	}
	
	public Boolean doElementDisplayedWait(By locator, int duration, long interval)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(duration, interval));
		return wait.until(ExpectedConditions.visibilityOf(getElement(locator))).isDisplayed();
	}
	
	public Boolean doElementEnabledWait(By locator, int duration)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		return wait.until(ExpectedConditions.visibilityOf(getElement(locator))).isEnabled();
	}
	public Boolean doElementEnabledWait(By locator, int duration, long interval)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(duration, interval));
		return wait.until(ExpectedConditions.visibilityOf(getElement(locator))).isEnabled();
	}
	
	public Boolean doElementSelectedWait(By locator, int duration)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		return wait.until(ExpectedConditions.visibilityOf(getElement(locator))).isSelected();
	}
	
	public Boolean doElementSelectedWait(By locator, int duration, long interval)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(duration, interval));
		return wait.until(ExpectedConditions.visibilityOf(getElement(locator))).isSelected();
	}
	
	
	
	

}
