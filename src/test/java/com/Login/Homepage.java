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
	By companiesLink = By.linkText("Companies");
	
	public Homepage(WebDriver driver){
		this.driver = driver;
		SeleniumUtilities s = new SeleniumUtilities(driver);
		wait = s.GetWebdriverWait();
	}
	
	public void getUserName() {
		driver.findElement(loginname).getText();
	}
	
	public void logout() {
		driver.findElement(listbox).click();		
		wait.until(ExpectedConditions.presenceOfElementLocated(logout));
		driver.findElement(logout).click();	
		
	}
	
	public void clickCompanies()
	{
		driver.findElement(companiesLink).click();
	}
}
