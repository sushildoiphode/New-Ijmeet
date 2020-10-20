package com.ijmeet.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {
	@Given("User is on login page")
	public void openLoginPage() {
		System.out.println("User open login page successfully");
	}
	@When("Enter username and password")
	public void enterCredentials() {
		System.out.println("User enter valid name and password");
	}
	@And("Click on login button")
	public void clickOnLoginBtn() {
		System.out.println("User click on Login button");
	}
	@Then("User is navigate to the homepage")
	public void backToHomePage() {
		System.out.println("User back to homepage");
	}
	

}
