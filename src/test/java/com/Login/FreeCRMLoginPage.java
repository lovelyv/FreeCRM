package com.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.reusableFunctions.SeleniumUtilities;

public class FreeCRMLoginPage {
	WebDriver driver;
	WebDriverWait wait;
	SeleniumUtilities sUtil;
	
	By username = By.name("email");
	By password = By.name("password");
	By loginbutton = By.cssSelector("div.ui.fluid.large.blue.submit.button");
	By loginerror = By.cssSelector("div.ui.negative.message p");
	
	public FreeCRMLoginPage(WebDriver driver){
		this.driver = driver;		
		sUtil = new SeleniumUtilities(driver);
		wait = sUtil.GetWebdriverWait();
	}
	
	public void setLoginUserName(String uname) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(username));
		driver.findElement(username).sendKeys(uname);
	}
	
	public void setLoginPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void Login() {
		driver.findElement(loginbutton).click();		
	}
	
	public WebElement GetErrorMessage() {
		return 	driver.findElement(loginerror);
	}
	
	public boolean isLoginButton()
	{
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(loginbutton));
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	
	

}
