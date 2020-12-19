package com.baseClasses;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeTest;

import io.cucumber.java.Before;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverBase 
{

//	private static List<DriverFactory> webDriverThreadPool = Collections.synchronizedList(new ArrayList<DriverFactory>());
//	private static ThreadLocal<DriverFactory> driverThread;
	
//	@Before(alwaysRun = true)
//	public static void instantiateDriverObject() 
//	{
//		driverThread = new ThreadLocal<DriverFactory>() 
//		{
//			@Override
//			protected DriverFactory initialValue()
//			{
//		          DriverFactory webDriverThread = new DriverFactory();
//		          webDriverThreadPool.add(webDriverThread);
//			      return webDriverThread;
//			}
//		};
//	}
//	
//	public static WebDriver getDriver() 
//	{
//		return driverThread.get().GetWebDriver();
//	}
//	
//	@AfterMethod(alwaysRun = true)
//	public static void clearCookies() 
//	{
//		getDriver().manage().deleteAllCookies();
//	}
//	
//	@AfterTest(alwaysRun = true)
//	public static void closeDriverObjects() 
//	{
//		for (DriverFactory webDriverThread : webDriverThreadPool) 
//		{
//	            webDriverThread.tearDown();
//		}	    
//	}
}
