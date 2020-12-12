package com.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FreeCRMLoginPage {
	WebDriver driver;
	
	By username = By.name("email");
	By password = By.name("password");
	By loginbutton = By.cssSelector("div.ui.fluid.large.blue.submit.button");
	
	
	public FreeCRMLoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void setLoginUserName(String uname) {
		driver.findElement(username).sendKeys(uname);
	}
	
	public void setLoginPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void Login() {
		driver.findElement(loginbutton).click();
	}
	

}
