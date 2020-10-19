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
	
	@FindBy(xpath="//div/div//div/div/p[text()=' United security Building, 3rd floor. ']")
	public static WebElement address1;
	
//	@FindBy(xpath="//div/div//div/div/p[text()=' United security Building, 3rd floor. ']/br")
//	public static WebElement address2;
	
	@FindBy(xpath="//p[text()='	+968 7246 7778']")
	public static WebElement whatsapp;
	
	@FindBy(xpath="//p[text()='+968 2422 2415']")
	public static WebElement mobileNo;
	
	@FindBy(xpath="//p[text()='info@ijtimaati.com                            ']")
	public static WebElement emailId;
	
	
	


	public static boolean isUserNameCheckBoxVisible() {
		boolean verify = Keywords.isElementDisplayed("css", userName);
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
	//	String text=address.getText();
		String text=address1.getText();
		return text;
	}
	public String verifyWhatsappText() {
			String text=whatsapp.getText();
			return text;
		}
	
	public String verifyMobileNoText() {
		String text=mobileNo.getText();
		return text;
	}
	public String verifyEmailIdText() {
		String text=emailId.getText();
		return text;
	}
	

}
