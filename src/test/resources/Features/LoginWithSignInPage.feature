Feature: Check whether homepage visible or not
Background: Browser is open
    Given Browser is open
   
Scenario Outline: Check login is successfully with valid credentials.
	When click on Sign in btn
	When user enters <username> and <password>
	And click on sign-in button
	Then user enters the meeting page
	
	Examples: 
		|username|password|
		|sushildoiphode@gmail.com|Sushil@12345|