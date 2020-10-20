Feature: Fealure to test login functionality
@SmokeTest
Scenario: Check login is successfully with valid credentials
	Given User is on login page
	When Enter username and password
	And Click on login button
	Then User is navigate to the homepage