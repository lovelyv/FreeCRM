Feature: User Login feature
Background:
#here we give the GIVEN  step as its common to all the senarios
Given user on the Login Page

	Scenario: Verify login functionality with valid emailid and invalid password
#	Given user on the Login Page
	When User enters valid emailid as "qabrief@gmail.com" and valid password as  "luvTester123"
	Then user click  login button
	Then user see full name in home page
#	And user can logout
	
	
	Scenario: Verify login functionality with valid emailid and invalid password
#	Given user on the Login Page
	When User enters valid emailid as "qabrief@gmail.com" and valid password as  "123"
	Then user click  login button
	Then user cannot login to application
#	
	Scenario: Verify login functionality with invalid emailid and valid password
#	Given user on the Login Page
	When User enters valid emailid as "123" and valid password as  "valid"
	Then user click  login button
	Then user cannot login to application
	
	Scenario: Verify login functionality with empty emailid and empty password
#	Given user on the Login Page
	When User enters valid emailid as " " and valid password as  " "
	Then user click  login button
	Then user cannot login to application
	
#		And user enters Email_id and Password
#			| Email_id | Password |
#			|qabrief@gmail.com|luvTester123|
#			|qab@gmail.com|abcdefgj|
#			|         |abcdefgj|
#			|asdfsdf|       |
#	
#		And user click Login button
#		Then user should see user full name in home page
#
