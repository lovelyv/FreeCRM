package com.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.reusableFunctions.SeleniumUtilities;

public class Homepage {
	WebDriver driver;
	WebDriverWait wait;
	By loginname = By.xpath("//div[text()='Beta'] //following-sibling::div/span");
	By listbox = By.cssSelector("div[role='listbox']");
	By logout = By.xpath("//div[@class='menu transition visible']/a/span[text()='Log Out']");
	By leftnav = By.id("main-nav");
	By companyIcon = By.cssSelector("a[href=\"/companies\"] i.building.icon");
	By companyLink = By.linkText("Companies");
	By Newbutton = By.cssSelector("a[href='/companies/new'] button");
	
	public Homepage(WebDriver driver){
		this.driver = driver;
		SeleniumUtilities s = new SeleniumUtilities(driver);
		wait = s.GetWebdriverWait();
	}
	
	public boolean isPageLoaded()
	{
		wait.until(ExpectedConditions.urlContains("home"));
		if (driver.getCurrentUrl() =="https://ui.freecrm.com/home")
		{
			return true;
		}
		else
			return false;
	}
	
	public String getUserName() {
		wait.until(ExpectedConditions.presenceOfElementLocated(loginname));
        return	driver.findElement(loginname).getText();
	}
	
	public void logout() {
		wait.until(ExpectedConditions.presenceOfElementLocated(listbox));
		driver.findElement(listbox).click();		
		wait.until(ExpectedConditions.presenceOfElementLocated(logout));
		driver.findElement(logout).click();	
		
		
	}
	
	public void clickCompanies()
	{
		driver.findElement(leftnav).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(companyIcon));
		driver.findElement(companyIcon).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(companyLink));
		driver.findElement(companyLink).click();
		driver.findElement(Newbutton).click();
		
	}
}
