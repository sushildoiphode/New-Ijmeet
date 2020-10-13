package com.ijmeet.functionaltests;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ijmeet.keywords.FEKeywords;
import com.ijmeet.pages.SignInpage;
import com.ijmeet.util.Constant;
import com.ijmeet.util.FileUtil;
import com.ijmeet.util.TestBase;

public class SignInPageTest extends TestBase{
	
	private static Logger log = Logger.getLogger(SignInPageTest.class);
	
	@BeforeMethod
	public void clickOnSignInBtn() throws InterruptedException {
		Constant.driver.findElement(By.xpath("//a[@href='https://ijmeet.com/login']")).click();
		Thread.sleep(3000);
	}
	
	@Test
	public void verifySignInTextVisibility() {
		SignInpage sign=PageFactory.initElements(Constant.driver, SignInpage.class);
		String actualText=sign.isSignInTextVisible();
		String expectedText= "Sign In";
		Assert.assertEquals(actualText, expectedText,"Text not match");
	}
	
	@Test
	public void verifyEmailAddressLabelVisibilityTest() {
		SignInpage sign=PageFactory.initElements(Constant.driver, SignInpage.class);
		String actualText=sign.isEmailAddresslabelvisible();
		String expectedText= "Email Address";
		Assert.assertEquals(actualText, expectedText,"Label not match");
	}
	
	@Test
	public void verifyPasswordLabelVisibilityTest() {
		SignInpage sign=PageFactory.initElements(Constant.driver, SignInpage.class);
		String actualText=sign.isPasswordlabelvisible();
		String expectedText= "Password";
		Assert.assertEquals(actualText, expectedText,"Label not match");
	}
	
	@Test
	public void verifyEmailAddressTextboxVisibilityTest() {
		SignInpage sign=PageFactory.initElements(Constant.driver, SignInpage.class);
		boolean email=sign.isEmailAddressTextboxVisible();
		Assert.assertTrue(email,"Email Address Textbox not visible");
	}
	
	@Test
	public void verifyPasswordTextboxVisibilityTest() {
		SignInpage sign=PageFactory.initElements(Constant.driver, SignInpage.class);
		boolean password=sign.isPasswordTextboxVisible();
		Assert.assertTrue(password,"Password Textbox not visible");
	}
	
	@Test
	public void verifyForgotYourPasswordVisibilityTest() {
		SignInpage sign=PageFactory.initElements(Constant.driver, SignInpage.class);
		boolean forgotPassword=sign.isForgotYourPasswordLinkVisible();
		Assert.assertTrue(forgotPassword,"Forgot your password link not visible");
	}
	

	@Test
	public void verifySignInButtonVisibilityTest() {
		boolean signinbtn=FEKeywords.isElementDisplayed("XPATH", FileUtil.getProperty("SignIn.signbutton"));
		Assert.assertTrue(signinbtn,"Sign In button not visible");
		log.info("Sign In button visible "+ signinbtn);
	}
	
	@Test
	public void verifySignUplinkVisibilityTest() {
		boolean signuplink=FEKeywords.isElementDisplayed("XPATH", FileUtil.getProperty("SignIn.signuplink"));
		Assert.assertTrue(signuplink,"Sign Up link not visible");
		log.info("Sign Up link visible "+ signuplink);
	}
	
	@Test
	public void verifySignUpclickabilityTest() {
		FEKeywords.clickOnElement("XPATH", FileUtil.getProperty("SignIn.signuplink"));
		String actualUrl=Constant.driver.getCurrentUrl();
		String expectedUrl="https://ijmeet.com/register";
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	

}
