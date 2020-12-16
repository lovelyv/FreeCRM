Feature: User Login feature
Description: This feature will test the Login and Logout functionality
Background:
#here we give the GIVEN  step as its common to all the senarios
Given user on the Login Page


	Scenario: Successful login with valid emailid and valid password
#	Given user on the Login Page
    #Parameterizing without Example Keyword, data is passed without example keyword
	When User enters valid emailid as "qabrief@gmail.com" and valid password as  "luvTester123"	
	And user click  login button	
	Then user see full name 
	And user clicks on logout button
	Then user see the login page
	
	
	
	Scenario Outline: Verify login functionality with valid emailid and invalid password
	When User enters emailid as "<emailid>" and password as  "<password>"	
	And user click  login button
	Then Message displayed Wrong emailid or password
   Examples:
	| emailid | password |
	| qabrief@gmail.com | 123 |
	| 123 | valid |	

	
	Scenario: Verify login functionality with empty emailid and empty password
	When User enters valid emailid as " " and valid password as  " "
	And user click  login button
#	But the emailid and password are empty strings
	Then Message displayed Wrong emailid or password
		
