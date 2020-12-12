package com.Companies;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class FreeCRMCompanyPage {
	
	WebDriver driver;
	public FreeCRMCompanyPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By name = By.xpath("//div[@class='ui field']/label[text()='Name']");
	By website = By.name("url");
	By fetch = By.xpath("//button[text()='Fetch']");
	By city = By.name("city");
	By state = By.name("state");
	By zip = By.name("zip");
	By country = By.name("country");
	By phonenumber = By.cssSelector("//div[@class='ui field']/label[text()='Phone'] /parent::div//descendant::input[2]");
	By homenumber = By.cssSelector("//div[@class='ui field']/label[text()='Phone'] /parent::div//descendant::input[3]");
	By twitterhandle = By.cssSelector("div.ui.input input[placeholder='Twitter handle']");
	By industry = By.cssSelector("input[name='industry']");
	By noofemployees = By.cssSelector("input[name='num_employees']");
	By symbol = By.cssSelector("input[name='symbol']");
	By revenue = By.cssSelector("input[name='annual_revenue']");
	String priorityPath = "//div[@name='priority']/div/div/span[text()='{}']";
	By priority = By.xpath(priorityPath);
	String statusPath = "//div[@name='status']/div/div/span[text()='{}']";
	By status = By.xpath(statusPath);
	String sourcePath = "//div[@name='source']/div/div/span[text()='{}']";
	By source = By.xpath(sourcePath);
	String categoryPath = "//div[@name='category']/div/div/span[text()='Client']";
	By category = By.xpath(categoryPath);
	By vatnumber = By.name("vat_number");
	By identifier= By.name("identifier");
	By image = By.name("image");
	By save = By.cssSelector("button.ui.linkedin.button");
	
			
	public void SetCompanyData(List<String> values)
	{
//		foreach()
		
	}
	
	public void SaveCompany() {
		driver.findElement(save).click();
	}



}
