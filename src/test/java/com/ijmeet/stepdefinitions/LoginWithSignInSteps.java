package com.ijmeet.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.ijmeet.keywords.FEKeywords;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginWithSignInSteps {
	
	WebDriver driver;
	
	@Given("Browser is open")
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.ijmeet.com/");	
	}
	@When("click on Sign in btn")
	public void clickSignInBtn() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()=' Sign In ']")).click();
		Thread.sleep(10000);
	}
	@When("^user enters (.*) and (.*)$")
	public void enterCredentials(String username, String password) {
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
	}
	@And("click on sign-in button")
	public void clickOnbtn() {
		driver.findElement(By.xpath("//button[text()='  Sign In ']")).click();
	}
	@Then("user enters the meeting page")
	public void verifyMeetingPage() {
		System.out.println("Meeting page visible");
	}

}

