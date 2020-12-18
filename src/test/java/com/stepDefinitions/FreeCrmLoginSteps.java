package com.stepDefinitions;

import java.util.List;

import org.testng.Assert;

import com.Login.FreeCRMLoginPage;
import com.Login.Homepage;
import com.baseClasses.Library;
import com.reusableFunctions.SeleniumUtilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FreeCrmLoginSteps extends Library {
	FreeCRMLoginPage login;
	Homepage homepage;
	SeleniumUtilities sUtil;
	
	@Given("user on the Login Page")
	public void user_on_the_Login_Page() {
	    // Write code here that turns the phrase above into concrete actions
		 
		 login = new FreeCRMLoginPage(driver);
		 sUtil = new SeleniumUtilities(driver);
	}

	@When("User enters valid emailid as {string} and valid password as  {string}")
	public void user_enters_valid_emailid_as_and_valid_password_as(String emailid, String password) {
		
		login.setLoginUserName(emailid);
		login.setLoginPassword(password);
	}

	@When("user click  login button")
	public void user_click_login_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		Library.logger.info("at login button");
		login.Login();		
		
	}

	@Then("user see full name")
	public void user_see_full_name() {
	    // Write code here that turns the phrase above into concrete actions
		Library.logger.info("at home page");	
		homepage = new Homepage(driver);
		String username = homepage.getUserName();
		Library.logger.info("User "+ username +" has logged in");
		Assert.assertEquals("LOVELY VENU", username.toUpperCase());		
		
	}

	@Then("user clicks on logout button")
	public void user_clicks_on_logout_button()  {
	    // Write code here that turns the phrase above into concrete actions
	    homepage.logout();	
	}	

	@Then("user see the login page")
	public void user_is_logged_out_of_the_application() {
	    // Write code here that turns the phrase above into concrete actions
		boolean isloginbuttonvisible = login.isLoginButton();
		Assert.assertTrue(isloginbuttonvisible);
		Library.logger.info("User has logged out");		
	}

	@When("User enters emailid as {string} and password as  {string}")
	public void user_enters_emailid_as_and_password_as(String emailid, String password) {

		login.setLoginUserName(emailid);
		login.setLoginPassword(password);
	}

	@Then("Message displayed Wrong emailid or password")
	public void message_displayed_Wrong_emailid_or_password() {
		String errorMessage = login.GetErrorMessage().getText();
		System.out.println(errorMessage);
		boolean contains =  errorMessage.toLowerCase().contains("invalid login");
		Assert.assertTrue(contains);
	}	
	
}
