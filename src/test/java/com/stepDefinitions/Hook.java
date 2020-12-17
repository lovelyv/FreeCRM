package com.stepDefinitions;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.Login.Homepage;
import com.baseClasses.DriverBase;
import com.baseClasses.Library;
import com.reusableFunctions.SeleniumUtilities;

//import com.baseClasses.Library;
//import com.reusableFunctions.SeleniumUtilities;


import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


//https://www.axelerant.com/resources/team-blog/how-work-cucumber-hooks
//https://developers.perfectomobile.com/display/PD/Parallel+Execution+in+cucumber+using+TestNG
public class Hook extends Library {

	By listbox = By.cssSelector("div[role='listbox']");
	By logout = By.xpath("//div[@class='menu transition visible']/a/span[text()='Log Out']");
	
	
	
	@Before
	public void init() {
		browserSetUp();
	}
	

	@After(order = 1)
	public void Signout(Scenario scenario) {
		if (!scenario.isFailed())
		{			
			if ( !driver.getCurrentUrl().equals("https://ui.cogmento.com/"))
			{				
				System.out.println("Signed out from the application");
				wait.until(ExpectedConditions.presenceOfElementLocated(listbox));
				driver.findElement(listbox).click();		
				wait.until(ExpectedConditions.presenceOfElementLocated(logout));
				driver.findElement(logout).click();
			}
		}
	}
	
	@After(order = 0)
	public void ScenarioTeardown(Scenario scenario) {
		
//		if (scenario.isFailed())
		{
			SeleniumUtilities su = new SeleniumUtilities(driver);
			Random rand = new Random();
			su.to_take_screenshot(scenario.getName() + rand.nextInt()  + ".png" );
			Library.logger.info(scenario.getName() + " Failed");

		}
		tearDown();
	}
	
//	@AfterStep
//	public void logAssertionErrorMessage() {
//	}
	
	
}
