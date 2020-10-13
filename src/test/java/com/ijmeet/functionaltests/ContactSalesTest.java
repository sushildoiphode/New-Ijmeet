package com.ijmeet.functionaltests;

import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ijmeet.keywords.Keywords;
import com.ijmeet.pages.ContactSalesPage;
import com.ijmeet.util.Constant;
import com.ijmeet.util.TestBase;

/**
 * 
 *@author Deepak Dude
 * Project-IJmeet
 */
public class ContactSalesTest extends TestBase {
	private static Logger log = Logger.getLogger(Keywords.class);
	ContactSalesPage contact;
	
	@BeforeMethod
	public void initializePage() {
		contact = new ContactSalesPage();
		Constant.driver.findElement(By.xpath("//*[@id=\"navbarContent\"]/ul/li[3]/a")).click();;
	}
	
	@Test
	public void verifyContactSalesPageTest() {
		String actualtitle = Constant.driver.getTitle();
		String expectedTitle = "IJmeet";
		Assert.assertEquals(expectedTitle, actualtitle);
		log.info("ContactSalesPage is available for IJmeet");

	}
	@Test
	public void isNameTextBoxAvailableTest() {
		boolean verify=contact.isUserNameCheckBoxVisible();
		Assert.assertTrue(verify);
		log.info("Name text box is availabel");
	}
	@Test
	public void isNameTextBoxClickableTest() throws InterruptedException {
		contact.sendTextToUserNameCheckBox();
		Thread.sleep(10000);
		String actualValue=contact.getValueFromTextbox();
		String expectedValue="Deepak Dude";
		System.out.println(actualValue);
		Assert.assertEquals(actualValue, expectedValue);
		log.info("We can click on Name textbox");
		
	}
	@Test
	public void isEmailTextBoxAvailableTest() {
		boolean verify=contact.isEmailCheckBoxVisible();
		Assert.assertTrue(verify);
		log.info("Email TextBox is available");
	}
	@Test
	public void isEmailTextBoxClickableTest() throws InterruptedException {
		contact.sendTextToEmailCheckBox();
		Thread.sleep(10000);
		String actualValue=contact.getValueFromEmailTextbox();
		String expectedValue="deepakdude938@gmail.com";
		System.out.println(actualValue);
		Assert.assertEquals(actualValue, expectedValue);
		
	}
	
	@Test
	public void isMessageTextBoxAvailableTest() {
		boolean verify=contact.isMessageCheckBoxVisible();
		Assert.assertTrue(verify);
		log.info("Message text box is available");
	}
	
	
	@Test
	public void isMessageTextBoxClickableTest() throws InterruptedException {
		contact.sendTextToMessageCheckBox();
		Thread.sleep(10000);
		String actualValue=contact.getValueFromMessageTextbox();
		String expectedValue="Ok done ,dona done";
		System.out.println(actualValue);
		Assert.assertEquals(actualValue, expectedValue);
	}
	
	public void toVerifySendButton() {
		
	}
	@Test
	public void toVerifyAddressText() {
		String actualAddress=contact.verifyAddressContents();
		System.out.println(actualAddress);
		
	}
	

}
