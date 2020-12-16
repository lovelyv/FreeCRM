package com.stepDefinitions;

import java.util.List;

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
		Library.logger.info("User "+ homepage.getUserName() +" has logged in");
//		sUtil.to_take_screenshot("validloginpage.png");	 	
		
	}

	@Then("user clicks on logout button")
	public void user_clicks_on_logout_button()  {
	    // Write code here that turns the phrase above into concrete actions
	    homepage.logout();	
	}	

	@Then("user see the login page")
	public void user_is_logged_out_of_the_application() {
	    // Write code here that turns the phrase above into concrete actions
		login.isLoginButton();
		Library.logger.info("User has logged out");		
	}

	@When("User enters emailid as {string} and password as  {string}")
	public void user_enters_emailid_as_and_password_as(String emailid, String password) {

		login.setLoginUserName(emailid);
		login.setLoginPassword(password);
	}

	@Then("Message displayed Wrong emailid or password")
	public void message_displayed_Wrong_emailid_or_password() {

		Library.logger.info(login.GetErrorMessage().getText());
	}	
	
}
