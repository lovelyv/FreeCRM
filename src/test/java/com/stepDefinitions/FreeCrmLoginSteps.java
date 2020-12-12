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
		 browserSetUp();
		 login = new FreeCRMLoginPage(driver);
		 sUtil = new SeleniumUtilities(driver);
	}

	@When("User enters valid emailid as {string} and valid password as  {string}")
	public void user_enters_valid_emailid_as_and_valid_password_as(String username, String password) {
	    // Write code here that turns the phrase above into concrete actions
		login.setLoginUserName(username);
		login.setLoginPassword(password);
	}

	@Then("user click  login button")
	public void user_click_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		logger.info("at login button");
		login.Login();
	}

	@Then("user see full name in home page")
	public void user_see_full_name_in_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		logger.info("at home page");	
		 homepage = new Homepage(driver);
		 sUtil.to_take_screenshot("validloginpage.png");
		 tearDown();
	}

	@Then("user cannot login to application")
	public void user_cannot_login_to_application() {
	    // Write code here that turns the phrase above into concrete actions
		sUtil.to_take_screenshot("invalidlogin.png");
		tearDown();
	}


	

//@Given("user on the Login Page")
//public void user_on_the_Login_Page() {
//    // Write code here that turns the phrase above into concrete actions
//	 browserSetUp();
//	 login = new FreeCRMLoginPage(driver);
//	 sUtil = new SeleniumUtilities(driver);
//}
//
//@When("User enters valid emailid as {string} and valid password as  {string}")
//public void user_enters_valid_emailid_as_and_valid_password_as(String username, String password) {
//    // Write code here that turns the phrase above into concrete actions
//	login.setLoginUserName(username);
//	login.setLoginPassword(password);
//}
//
//
//@Then("user click  login button")
//public void user_click_login_button() {
//    // Write code here that turns the phrase above into concrete actions
//	logger.info("at login button");
//	login.Login();
//}
//
//@Then("user see full name in home page")
//public void user_see_full_name_in_home_page() {
//    // Write code here that turns the phrase above into concrete actions
////    throw new io.cucumber.java.PendingException();
//	
//	logger.info("at home page");	
//	 homepage = new Homepage(driver);
//	 sUtil.to_take_screenshot("validloginpage.png");
//}
//
//@Then("user can logout")
//public void user_can_logout() {
//    // Write code here that turns the phrase above into concrete actions
//	logger.info("at home page logout");
//    homepage.logout();
//    sUtil.to_take_screenshot("logout.png");
//    tearDown();
//}
//
//
//
//
//@Then("user cannot login to application")
//public void user_cannot_login_to_application() {
//    // Write code here that turns the phrase above into concrete actions
////    throw new io.cucumber.java.PendingException();
//	sUtil.to_take_screenshot("invalidlogin.png");
//	tearDown();
//}






}
