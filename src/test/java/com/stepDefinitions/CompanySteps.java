package com.stepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Companies.FreeCRMCompanyPage;
import com.Login.FreeCRMLoginPage;
import com.Login.Homepage;
import com.baseClasses.Library;
import com.reusableFunctions.SeleniumUtilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CompanySteps extends Library {

	FreeCRMLoginPage login;
	Homepage homepage;
	SeleniumUtilities sUtil;
	FreeCRMCompanyPage companypage;
	

	
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		 login = new FreeCRMLoginPage(driver);
	}

	
	@When("User submits emailid and password")
	public void user_submits_emailid_and_password() {
	    // Write code here that turns the phrase above into concrete actions
		login.setLoginUserName(Library.properties.getProperty("emailid"));
		login.setLoginPassword(Library.properties.getProperty("password"));

	}

	@When("User clicks on Login button")
	public void user_clicks_on_Login_button() {
	    // Write code here that turns the phrase above into concrete actions
		login.Login();
	}

	@Then("User logs in to the application")
	public void user_logs_in_to_the_application() {
	    // Write code here that turns the phrase above into concrete actions
		Library.logger.info("at home page");	
		homepage = new Homepage(driver);
		 Assert.assertEquals("LOVELY VENU", homepage.getUserName());
	}

	@Given("user clicks on Company link on homepage and clicks on new button and enters all details")
	public void user_clicks_on_Company_link_on_homepage_and_clicks_on_new_button_and_enters_all_details(io.cucumber.datatable.DataTable table) throws Throwable {
		    List<Map<String, String>> rows = table.asMaps(String.class, String.class);		
		    companypage = new FreeCRMCompanyPage(driver);
		    CustomSoftAssert sa= new CustomSoftAssert(driver,"companyfail");
			for (Map<String, String> row : rows) 
			{
				homepage.clickCompanies();
				
		        companypage.SetCompanyData1(row);
		        companypage.SetCompanyData2(row);
		        companypage.SetCompanyData3(row);
		        companypage.SaveCompany();	
		        Thread.sleep(1000);
		        boolean companyNotCreated = driver.getCurrentUrl().contains("new");
		        sa.assertFalse(companyNotCreated);
		        if (companyNotCreated)
		        {
		        	Library.logger.info("Cannot create company, " + row.get("Name"));
		        }
		        else
		        {  Library.logger.info("Created company, " + row.get("Name")); }
			    
		    }
			sa.assertAll();				
	}
	
//	@And("User enters company address")
//	public void user_enters_company_address(io.cucumber.datatable.DataTable table) {
//	    List<Map<String, String>> rows = table.asMaps(String.class, String.class);
//	    for (Map<String, String> row : rows) 
//		{
//	    	
//		}
//	}

	@Then("companies are created")
	public void companies_are_created() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
	}

	

//		@Given("User navigates to login page")
//		public void user_navigates_to_login_page() {
//		    // Write code here that turns the phrase above into concrete actions
//			 browserSetUp();
//			 login = new FreeCRMLoginPage(driver);
//			 sUtil = new SeleniumUtilities(driver);
//		}
//
//		@When("User submits emailid and password")
//		public void user_submits_emailid_and_password() {
//		    // Write code here that turns the phrase above into concrete actions
//			login.setLoginUserName(properties.getProperty("emailid"));
//			login.setLoginPassword(properties.getProperty("password"));
//		}
//
//		@When("User clicks on Login button")
//		public void user_clicks_on_Login_button() {
//		    // Write code here that turns the phrase above into concrete actions
//			logger.info("at login button");
//			login.Login();		
//		}
//
//		@Then("User logs in to the application")
//		public void user_logs_in_to_the_application() {
//		    // Write code here that turns the phrase above into concrete actions
//			logger.info("at home page");	
//			 homepage = new Homepage(driver);
//		}
//
//		@Given("user clicks on Company link on homepage and clicks on new button")
//		public void user_clicks_on_Company_link_on_homepage() {
//		    // Write code here that turns the phrase above into concrete actions			 
//			 homepage.clickCompanies();
//			 companypage = new FreeCRMCompanyPage(driver);
//		}
//
//		@When("user enters Name,Website and location details and phonenumbers and other details and clicks on save")
//		public void user_enters_Name_Website_and_location_details(DataTable table) {
//		    List<Map<String, String>> rows = table.asMaps(String.class, String.class);
//			
//			for (Map<String, String> columns : rows) 
//			{
//		        companypage.SetCompanyData1(columns);
//		        companypage.SetCompanyData2(columns);
//		        companypage.SetCompanyData3(columns);
//		        companypage.SaveCompany();
//		    }		
//		}		
//
//		@Then("companies are created")
//		public void a_new_company_is_created() {
//		    // Write code here that turns the phrase above into concrete actions
////			if companypage.checkCompanyName(valu)
//		}



}
