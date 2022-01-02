package com.leaftaps.qa.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory 
{
	public WebDriver driver;
	public Properties prop; 
	public OptionManager optionManager;
	public static ThreadLocal<WebDriver> tl = new ThreadLocal<WebDriver>();
	
	
	public WebDriver initilized_driver(Properties prop)
	{
		 optionManager = new OptionManager(prop);
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			tl.set(new ChromeDriver(optionManager.chromeOption()));
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tl.set(new FirefoxDriver(optionManager.firefoxOption()));
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			tl.set(new EdgeDriver(optionManager.edgeOption()));
		}
		else
		{
			System.out.println("Please pass the correct browser" +browserName);
		}
		
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().fullscreen();
		
		return getDriver();
		
	}
	
	public synchronized WebDriver getDriver()
	{
		return tl.get();
	}
	
	public void loadURL(String url)
	{
		if(url==null)
		{
			System.out.println("Please pass the correct url");
		}
		else if(url.indexOf("http")==-1)
		{
			System.out.println("invlid url");
		}
		driver.get(url);
		
	}
	
	
	
	
	/**
	 * To run the test cases on different environment
	 * @return - prop object
	 */
	public Properties initilized_prop()
	{
		FileInputStream fs = null;
		prop = new Properties();
		String envName= System.getProperty("env");
		
		try
		{
		if(envName==null)
		{
			System.out.println("We are running on production environment");	
				fs = new FileInputStream("./src/test/resources/config/config.properties");
		}
		else
		{
			System.out.println("We are running on "+envName);
			switch (envName.toLowerCase()) 
			{
			case "qa":
				fs = new FileInputStream("./src/test/resources/config/qa_config.properties");
				break;
			case "int":
				fs = new FileInputStream("./src/test/resources/config/int_config.properties");
				break;
			default:
				System.out.println("Please pass the correct environment name");
				break;
			}
		}
		
		}
		catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		try {
			prop.load(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return prop;
	}
		
	}

