package com.stepDefinitions;

import java.util.List;

import com.Companies.FreeCRMCompanyPage;
import com.Login.FreeCRMLoginPage;
import com.Login.Homepage;
import com.baseClasses.Library;
import com.reusableFunctions.SeleniumUtilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CompanySteps extends Library {

//	FreeCRMLoginPage login;
	Homepage homepage;
	SeleniumUtilities sUtil;
	FreeCRMCompanyPage companypage;
	
	@Given("user has logged in and clicked on Company on Home page")
	public void user_has_logged_in_and_clicked_on_Company_on_Home_page() {
	    // Write code here that turns the phrase above into concrete actions
		browserSetUp();	
		logger.info("In company steps");
		sUtil = new SeleniumUtilities(driver);
		homepage = new Homepage(driver);
		homepage.clickCompanies();
	}

	@When("user enters all details")
	public void user_enters_all_details(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    throw new io.cucumber.java.PendingException();
	}

	@Then("user click on save button")
	public void user_click_on_save_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("user enters only mandatory fields")
	public void user_enters_only_mandatory_fields(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    List<String> values = dataTable.asList();
        companypage.SetCompanyData(values);
	}

	
	
	
//	@Given("user has logged in and clicked on Company on Home page")
//	public void user_has_logged_in_and_clicked_on_Company_on_Home_page() {
//	    // Write code here that turns the phrase above into concrete actions
////		browserSetUp();
////		login = new FreeCRMLoginPage(driver);
//		logger.info("In company steps");
//		sUtil = new SeleniumUtilities(driver);
//		homepage = new Homepage(driver);
//		homepage.clickCompanies();	    
//	}
//
//	@When("user enters all details")
//	public void user_enters_all_details(io.cucumber.datatable.DataTable dataTable) {
//	    // Write code here that turns the phrase above into concrete actions
//	    // For automatic transformation, change DataTable to one of
//	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
//	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
//	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
//	    //
//	    // For other transformations you can register a DataTableType.
//	    List<String> values = dataTable.asList();
////	    dataTable.
//	    companypage.SetCompanyData(values);
//	    
//	}
//
//	@Then("user click on save button")
//	public void user_click_on_save_button() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}



}
