package com.ijmeet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ijmeet.keywords.Keywords;
import com.ijmeet.util.Constant;

/**
 * 
 * @author Deepak Dude Project-IJmeet
 *
 */
public class ContactSalesPage {

	public ContactSalesPage() {
		PageFactory.initElements(Constant.driver, this);
	}

	@FindBy(xpath = "//input[@name='user_email']")
	public static WebElement email;

	@FindBy(xpath = "//textarea[@name='user_message']")
	public static WebElement message;

	@FindBy(xpath = "//input[@name='user_name']")
	public static WebElement userName;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-primary1 com-md-3 w-100 m-0']")
	public static WebElement sendButton;
	
	@FindBy(xpath="//div[@class='recaptcha-checkbox-border']")
	public static WebElement captcha;
	
	@FindBy(xpath="//h4[text()=' Address ']")
	public static WebElement address;
	
	@FindBy(xpath="//h4[text()=' Address ']")
	public static WebElement address1;


	public static boolean isUserNameCheckBoxVisible() {
		boolean verify = Keywords.isElementDisplayed("XPATH", userName);
		return verify;
	}

	public void sendTextToUserNameCheckBox() {
		userName.sendKeys("Deepak Dude");

	}

	public static String getValueFromTextbox() {
		return userName.getAttribute("value");
	}

	public static boolean isEmailCheckBoxVisible() {
		boolean verify = Keywords.isElementDisplayed("XPATH", email);
		return verify;
	}

	public void sendTextToEmailCheckBox() {
		email.sendKeys("deepakdude938@gmail.com");

	}

	public static String getValueFromEmailTextbox() {
		return email.getAttribute("value");
	}

	public static boolean isMessageCheckBoxVisible() {
		boolean verify = Keywords.isElementDisplayed("XPATH", message);
		return verify;
	}

	public void sendTextToMessageCheckBox() {
		message.sendKeys("Ok done ,dona done");

	}

	public static String getValueFromMessageTextbox() {
		return message.getAttribute("value");
	}

	public void toVerifySendButton() {
		Keywords.clickOnElement("XPATH", sendButton);
	}

	public void clickOnCaptcha() {
		Keywords.clickOnElement("XPATH", captcha);
	}
	public String verifyAddressContents() {
		String[] text=null;
	text[0]=address.getAttribute("value");
//	text[1]=
	System.out.println(text[0]);
		
		return text[0];
		
	}

}
