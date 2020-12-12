Feature: User can create new company
Background:
#here we give the GIVEN  step as its common to all the senarios
Given user has logged in and clicked on Company on Home page

Scenario: Verification of new company creation

When user enters all details
|Name|Website|City|State|Zip|Country|Phonenumber|Worknumber|Industry|Twitterhandle|Employeecount|Stocksymbol|annualrevenue|priority|status|source|category|Vatnumber|identifier|companyimage|

Then user click on save button


Scenario: Verification of new company creation

When user enters only mandatory fields
|Name|Website|City|State|Zip|Country|Phonenumber|Worknumber|Industry|Twitterhandle|Employeecount|Stocksymbol|annualrevenue|priority|status|source|category|Vatnumber|identifier|companyimage|

Then user click on save button



#And user enters Website
#And user clicks on Fetch button
#Then user see the description filled in description box


