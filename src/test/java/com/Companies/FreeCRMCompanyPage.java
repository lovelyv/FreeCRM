package com.Companies;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.reusableFunctions.SeleniumUtilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class FreeCRMCompanyPage {
	
	WebDriver driver;
	WebDriverWait wait;
	SeleniumUtilities sUtil;
	public FreeCRMCompanyPage(WebDriver driver)
	{
		this.driver = driver;
		sUtil = new SeleniumUtilities(driver);
		wait = sUtil.GetWebdriverWait();
	}
	
	By name = By.xpath("//div[@class='ui field']/label[text()='Name']/parent::div/div/div/input");
	By website = By.name("url");
	By fetch = By.xpath("//button[text()='Fetch']");
	
	By firstAddress = By.cssSelector("input[name='address']");
	By address = By.cssSelector("div.six.wide.fields input[name='address']");
	By city = By.cssSelector("div.six.wide.fields input[name='city']");
	By state = By.cssSelector("div.six.wide.fields input[name='state']");
	By zip = By.cssSelector("div.six.wide.fields input[name='zip']");	
	By countrytextbox = By.cssSelector("div.six.wide.fields div[name='country'] input[class='search']");	
	
	By addAddressbutton = By.cssSelector("div.six.wide.fields button i.add.icon");
	By removeAddressbutton = By.cssSelector("div.six.wide.fields button i.remove.icon");
	
	By phonenumber = By.xpath("//div[@class='ui field']/label[text()='Phone'] /parent::div//descendant::input[2]");
	By homenumber = By.xpath("//div[@class='ui field']/label[text()='Phone'] /parent::div//descendant::input[3]");
	
	By tagLocator = By.xpath("//label[text()='Tags']/parent::div/label/div/input");
	
	By twitterhandle = By.cssSelector("div.ui.input input[placeholder='Twitter handle']");
	By industry = By.cssSelector("input[name='industry']");
	By noofemployees = By.cssSelector("input[name='num_employees']");
	By symbol = By.cssSelector("input[name='symbol']");
	By revenue = By.cssSelector("input[name='annual_revenue']");

	By priority = By.xpath("//label[text()='Priority']/parent::div/div[@name='priority']");
	By priorityItems = By.cssSelector("div.visible.menu.transition span");
	
	By status = By.xpath("//label[text()='Status']/parent::div/div[@name='status']");
	By statusItems = By.cssSelector("div.visible.menu.transition span");
	
	By source = By.xpath("//label[text()='Source']/parent::div/div[@name='source']");
	By sourceItems = By.cssSelector("div.visible.menu.transition span");	
	
	By category = By.xpath("//label[text()='Category']/parent::div/div[@name='category']");
	By categoryItems = By.cssSelector("div.visible.menu.transition span");	
		
	By vatnumber = By.name("vat_number");
	By identifier= By.name("identifier");
	By image = By.name("image");
	By save = By.cssSelector("button.ui.linkedin.button i.save.icon");
	By companyName = By.cssSelector("div.ui.header.item.mb5.light-black i");
	
			
	/*|Name|Website|address|City|State|Zip|Country|*/
	public void SetCompanyData1(Map<String,String> values) throws Throwable
	{
		
		driver.findElement(name).sendKeys(values.get("Name"));
		driver.findElement(website).sendKeys(values.get("Website"));
		driver.findElement(fetch).click();
		
		Thread.sleep(2000);
		AddAddress(0,values);		
		AddAddress(1,values);
		AddAddress(2,values);
		driver.findElements(removeAddressbutton).get(3).click();
		
	}
	
	private void AddAddress(int index,Map<String,String> values) {
		wait.until(ExpectedConditions.visibilityOf(driver.findElements(address).get(index)));
		driver.findElements(address).get(index).click();	
		driver.findElements(address).get(index).sendKeys(values.get("address"));
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElements(city).get(index)));
		driver.findElements(city).get(index).sendKeys(values.get("City"));
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElements(state).get(index)));
		driver.findElements(state).get(index).sendKeys(values.get("State"));
		
		driver.findElements(zip).get(index).sendKeys(values.get("Zip")); 		
		
		driver.findElements(countrytextbox).get(index).sendKeys(values.get("Country"));
		driver.findElements(countrytextbox).get(index).sendKeys(Keys.ARROW_DOWN);
		driver.findElements(countrytextbox).get(index).sendKeys(Keys.ENTER);	
		driver.findElement(addAddressbutton).click();
		
	}
	
/*	|Phonenumber|Worknumber|Tag|Industry|Twitterhandle|Employeecount|Stocksymbol|annualrevenue|*/
	public void SetCompanyData2(Map<String,String> values)
	{
		
		driver.findElement(phonenumber).sendKeys(values.get("Phonenumber"));
		driver.findElement(homenumber).sendKeys(values.get("Worknumber"));
		String tags = values.get("Tag");
		String[] tag =	tags.split(" ");
		for(String s : tag) {
			driver.findElement(tagLocator).sendKeys(s);
			driver.findElement(tagLocator).sendKeys(Keys.ENTER);
		}
		
		driver.findElement(industry).sendKeys(values.get("Industry"));
		driver.findElement(twitterhandle).sendKeys(values.get("Twitterhandle"));
		driver.findElement(noofemployees).sendKeys(values.get("Employeecount"));
		driver.findElement(symbol).sendKeys(values.get("Stocksymbol"));
		driver.findElement(revenue).sendKeys(values.get("annualrevenue"));
	}
	
	
	/*|priority|status|source|category|Vatnumber|identifier|companyimage|*/
	public void SetCompanyData3(Map<String,String> values)
	{
		driver.findElement(priority).click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(priorityItems));
		List<WebElement> priorities =  driver.findElements(priorityItems);

		for(WebElement w : priorities) {
			
			if (w.getText().equals(values.get("priority")))
			{				
				w.click();
				break;
			}
		}
		

		driver.findElement(status).click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(statusItems));
		List<WebElement> statuses =  driver.findElements(statusItems);

		for(WebElement w : statuses) {
			
			if (w.getText().equals(values.get("status")))
			{				
				w.click();
				break;
			}
		}

		driver.findElement(source).click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(sourceItems));
		List<WebElement> sources =  driver.findElements(sourceItems);

		for(WebElement w : sources) {
			
			if (w.getText().equals(values.get("source")))
			{				
				w.click();
				break;
			}
		}

		
		driver.findElement(category).click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(categoryItems));
		List<WebElement> categories =  driver.findElements(categoryItems);

		for(WebElement w : categories) {
			
			if (w.getText().equals(values.get("category")))
			{				
				w.click();
				break;
			}
		}

		driver.findElement(vatnumber).sendKeys(values.get("Vatnumber"));
		driver.findElement(identifier).sendKeys(values.get("identifier"));
		driver.findElement(image).sendKeys(values.get("companyimage"));
		
	}
	
	public void SaveCompany() throws InterruptedException {
		driver.findElement(save).click();
		Thread.sleep(2000);	
		
	}
	
	

}
