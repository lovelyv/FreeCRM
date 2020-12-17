Feature: New Company creation
Background: User is logged in
	Given User navigates to login page
	When User submits emailid and password 
	And User clicks on Login button
	Then User logs in to the application
#here we give the GIVEN  step as its common to all the scenarios



Scenario: Verification of new company creation
	Given user clicks on Company link on homepage and clicks on new button and enters all details
	| Name | Website | address |City|State|Zip|Country|Phonenumber|Worknumber|Tag|Industry|Twitterhandle|Employeecount|Stocksymbol|annualrevenue|priority|status|source|category|Vatnumber|identifier|companyimage|
		|ABC Company|https://nextdoor.com/|linda ave|Sunnyvale|California|78965|Afghanistan|1234567896|3698521478|tag1 tag2|IT|handle|200|♀┼|100000|Low|Hot|Customer|Client|123E|Mr.x|D:\Pictures\2020-03-02 IPICS\IPICS 005.JPG|
		|Company|http://flyabacoair.com/ |200 mira road|Marsh|Marsh Harbor|78965|Bahamas|1523627896|3698521478|air fly|fly|handlefly|1200|♀┼|500|High|Inactive|Partner|Prospect|te123E|Mr.xkl|D:\Pictures\2020-03-02 IPICS\IPICS 005.JPG|
		|xyz Company|https://www.bakersdelight.com.au/|293 Camberwell Road|Camberwell|Victoria|78956|Australia|1523627896|3698521478|bakeryyum yummylicious|bakery|handlenew|1200|♀┼|500|Medium|On Hold|Event|Partner|123sdwE|Mr.xyj|D:\Pictures\2020-03-02 IPICS\IPICS 005.JPG|

	Then companies are created
#
#Scenario: Verify error message when invalid company website
#Given user is on company page
#When user enters invalid website url "http://asdfasdfasdfasdf.com"
#Then an error popup window is opened
#
#
#Scenario: Verify company cannot be created with empty spaces in company name
#Given user is on company page
#When user enters empty spaces in companyname "     "
#And user clicks on save
#Then user see the error message
#


#	And User enters company address
#	| address |City|State|Zip|Country|
#	|linda ave|Sunnyvale|California|78965|Afghanistan|
#    |200 mira road|Marsh|Marsh Harbor|78965|Bahamas|
#    |293 Camberwell Road|Camberwell|Victoria|78956|Australia|
#

