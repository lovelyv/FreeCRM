package com.baseClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory
{
	
private  WebDriver driver;
private  WebDriverWait wait;
//private  Properties properties = Library.properties;
//private  Logger logger = Library.logger;

public WebDriverWait GetWebdriverWait()
{
	return this.wait;
}

	
public WebDriver GetWebDriver() 
{
	if (null == driver)
	{
	Library L = new Library();
	String browser = Library.properties.getProperty("browser");

	
	System.out.println(browser);

	switch (browser.toLowerCase()) 
	{
	
	case "chrome":
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();	
	break;
	case "firefox":
	WebDriverManager.firefoxdriver().setup();
	driver = new FirefoxDriver();
	Library.logger.info(String.format("Identified the browser as %s. Launching the browser", browser));
	break;
	
	case "ie":
	WebDriverManager.iedriver().setup();
	driver = new InternetExplorerDriver();
	Library.logger.info(String.format("Identified the browser as %s. Launching the browser", browser));
	break;
	case "headlessbrowser":
	WebDriverManager.chromedriver().setup();
	ChromeOptions options=new ChromeOptions();
	options.setHeadless(true);
	driver=new ChromeDriver(options);
	
	default:		
		Library.logger.info(String.format("Could not identify the browser as %s. Please specify correct browser", browser));
	break;
	
	
  }
	}
 return driver;
}

public void tearDown() {
    this.driver.quit();
    Library.logger.info("Exiting the application and closing the browser");
}

}
