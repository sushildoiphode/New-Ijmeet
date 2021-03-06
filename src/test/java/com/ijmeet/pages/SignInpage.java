package com.ijmeet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ijmeet.keywords.Keywords;
import com.ijmeet.util.Constant;

public class SignInpage {
	
	public SignInpage() {
		PageFactory.initElements(Constant.driver, this);
	}
	 
	@FindBy(xpath="//h4[text()=' Sign In ']")
	private static WebElement signInText;
	@FindBy(xpath="//label[@for='email']")
	private static WebElement emailAddressLabel;
	@FindBy(xpath="//label[@for='password']")
	private static WebElement PasswordLabel;
	@FindBy(css = "input#email")
	private static WebElement emailAddressTextbox;
	@FindBy(css = "input#password")
	private static WebElement passwordTextbox;
	@FindBy(xpath = "//a[@class='auth-link text-black']")
	private static WebElement forgotYourPasswordLink;
	@FindBy(xpath = "//a[@class='social-login-button social-login-button-google']")
	private static WebElement signInWithGooglebutton;
	@FindBy(xpath = "//a[@class='social-login-button social-login-button-facebook']")
	private static WebElement signInWithFacebookbutton;
	
	public static String isSignInTextVisible() {
		return signInText.getText();
	}
	public static String isEmailAddresslabelvisible() {
		return emailAddressLabel.getText();
	}
	public static String isPasswordlabelvisible() {
		return PasswordLabel.getText();
	}
	public static boolean isEmailAddressTextboxVisible() {
		return emailAddressTextbox.isDisplayed();
	}
	public static boolean isPasswordTextboxVisible() {
		return passwordTextbox.isDisplayed();
	}
	public static boolean isForgotYourPasswordLinkVisible() {
		return Keywords.isElementDisplayed("XPATH", forgotYourPasswordLink);
	}
	public static void isForgotYourPasswordLinkClickable() {
		Keywords.clickOnElement("XPATH", forgotYourPasswordLink);
	}
	public static boolean isSignInWithGooglebuttonVisible() {
		return signInWithGooglebutton.isDisplayed();
	}
	public static boolean isSignInWithFacebookbuttonVisible() {
		return signInWithFacebookbutton.isDisplayed();
	}
	public static void isSignInWithGooglebuttonClickable() {
		 signInWithGooglebutton.click();
	}
	public static void isSignInWithFacebookbuttonClickable() {
		 signInWithFacebookbutton.click();
	}
	
	

}
