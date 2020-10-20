package com.ijmeet.functionaltests;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ijmeet.keywords.FEKeywords;
import com.ijmeet.keywords.Keywords;
import com.ijmeet.pages.SignInpage;
import com.ijmeet.util.Constant;
import com.ijmeet.util.FileUtil;
import com.ijmeet.util.TestBase;

public class SignInPageTest extends TestBase{
	
	private static Logger log = Logger.getLogger(SignInPageTest.class);
	
	@BeforeMethod
	public void clickOnSignInBtn() throws InterruptedException {
		FEKeywords.clickOnElement("XPATH", "//a[@href='https://ijmeet.com/login']");
		Thread.sleep(3000);
	}
	
	@Test
	public void verifyTitleOnSignInPage() {
		String actualTitle=Constant.driver.getTitle();
		String expectedTitle="IJmeet";
		log.info("Title name: "+actualTitle);
		Assert.assertEquals(actualTitle , expectedTitle);
	}
	
	@Test
	public void verifySignInTextVisibility() {
		SignInpage sign=PageFactory.initElements(Constant.driver, SignInpage.class);
		String actualText=sign.isSignInTextVisible();
		String expectedText= "Sign In";
		Assert.assertEquals(actualText, expectedText,"Text not match");
		log.info("Sign In heading text is available on Sign In page");
	}
	
	@Test
	public void verifyEmailAddressLabelVisibilityTest() {
		SignInpage sign=PageFactory.initElements(Constant.driver, SignInpage.class);
		String actualText=sign.isEmailAddresslabelvisible();
		String expectedText= "Email Address";
		Assert.assertEquals(actualText, expectedText,"Label not match");
		log.info("Email Address label is available on Sign In page");
	}
	
	@Test
	public void verifyPasswordLabelVisibilityTest() {
		SignInpage sign=PageFactory.initElements(Constant.driver, SignInpage.class);
		String actualText=sign.isPasswordlabelvisible();
		String expectedText= "Password";
		Assert.assertEquals(actualText, expectedText,"Label not match");
		log.info("Password Label is available on Sign In page");
	}
	
	@Test
	public void verifyEmailAddressTextboxVisibilityTest() {
		SignInpage sign=PageFactory.initElements(Constant.driver, SignInpage.class);
		boolean email=sign.isEmailAddressTextboxVisible();
		Assert.assertTrue(email,"Email Address Textbox not visible");
		log.info("Email Address textbox is visible on Sign In page");
	}
	
	@Test
	public void verifyPasswordTextboxVisibilityTest() {
		SignInpage sign=PageFactory.initElements(Constant.driver, SignInpage.class);
		boolean password=sign.isPasswordTextboxVisible();
		Assert.assertTrue(password,"Password Textbox not visible");
		log.info("Password textbox is visible on Sign In page");
	}
	
	@Test
	public void verifyForgotYourPasswordVisibilityTest() throws InterruptedException {
		SignInpage sign=PageFactory.initElements(Constant.driver, SignInpage.class);
		Thread.sleep(5000);
		boolean forgotPassword=sign.isForgotYourPasswordLinkVisible();
		Assert.assertTrue(forgotPassword,"Forgot your password link not visible");
		log.info("Forgot password link is visible on Sign In page");
	}
	
	@Test
	public void verifyForgotYourPasswordClickabilityTest() {
		SignInpage sign=PageFactory.initElements(Constant.driver, SignInpage.class);
		sign.isForgotYourPasswordLinkClickable();
		String newUrl=Constant.driver.getCurrentUrl();
		String expectedUrl="https://ijmeet.com/password/reset";
		Assert.assertEquals(newUrl, expectedUrl,"Url Mismatch");
		log.info("If user click on Forgot password link then it navigate to Reset Password page. i.e "+ newUrl);	
	}
	
	@Test
	public void verifySignUplinkVisibilityTest() {
		boolean signuplink=FEKeywords.isElementDisplayed("XPATH", FileUtil.getProperty("SignIn.signuplink"));
		Assert.assertTrue(signuplink,"Sign Up link not visible");
		log.info("Sign Up link visible "+ signuplink);
	}
	
	@Test
	public void verifySignUplinkClickabilityTest() {
		FEKeywords.clickOnElement("XPATH", FileUtil.getProperty("SignIn.signuplink"));
		String actualUrl=Constant.driver.getCurrentUrl();
		String expectedUrl="https://ijmeet.com/register";
		Keywords.navigateBack();
		Assert.assertEquals(actualUrl, expectedUrl);
		log.info("If user click on Sign Up link then it navigate to Sign Up page. i.e "+ actualUrl);
	}
	
	@Test
	public void verifyRememberMeCheckboxclickabilityTest() {
		FEKeywords.clickOnElement("XPATH", FileUtil.getProperty("SignIn.remembermecheckbox"));
		log.info("Checkbox is Clickable");
	}
	
	@Test
	public void verifySinInWithGoogleButtonVisibilityTest() {
		SignInpage sign=PageFactory.initElements(Constant.driver, SignInpage.class);
		boolean googletext=sign.isSignInWithGooglebuttonVisible();
		Assert.assertTrue(googletext,"Sign in with Google + button not visible");
		log.info("Sign in with Google + button is visible on Sign in page");
	}
	
	@Test
	public void verifySinInWithGoogleButtonClickabilityTest() {
		SignInpage sign=PageFactory.initElements(Constant.driver, SignInpage.class);
		sign.isSignInWithGooglebuttonClickable();
		String actualTitle=Constant.driver.getTitle();
		String expectedTitle="Sign in – Google accounts";
		Keywords.navigateBack();
		Assert.assertEquals(actualTitle, expectedTitle);
		log.info("If user click on Sign In with Google + button then it "
				+ "navigate to Gmail page. i.e "+ actualTitle);	
	}
	
	@Test
	public void verifySinInWithFacebookButtonVisibilityTest() {
		SignInpage sign=PageFactory.initElements(Constant.driver, SignInpage.class);
		boolean facebooktext=sign.isSignInWithFacebookbuttonVisible();
		Assert.assertTrue(facebooktext,"Sign in with Facebook button not visible");
		log.info("Sign in with Facebook button is visible on Sign in page");
	}
	
	@Test
	public void verifySinInWithFacebookButtonClickabilityTest() throws InterruptedException {
		SignInpage sign=PageFactory.initElements(Constant.driver, SignInpage.class);
		sign.isSignInWithFacebookbuttonClickable();
		String actualTitle=Constant.driver.getTitle();
		String expectedTitle="Log in to Facebook | Facebook";
		Keywords.navigateBack();
		Assert.assertEquals(actualTitle, expectedTitle);
		log.info("If user click on Sign In with Facebook button then it "
				+ "navigate to Facebook page. i.e "+ actualTitle);	
	}
	
	@Test
	public void verifySignInButtonVisibilityTest() {
		boolean signinbtn=FEKeywords.isElementDisplayed("XPATH", FileUtil.getProperty("SignIn.signinbutton"));
		Assert.assertTrue(signinbtn,"Sign In button not visible");
		log.info("Sign In button visible "+ signinbtn);
	}
	
	/**
	 * For this method registered Password should be available.
	 */
	@Test
	public void verifyInvalidEmailAddressErrorTest() {
		FEKeywords.enterText("CSS", "input#email", "abcd@gmail.com");
		FEKeywords.enterText("CSS", "input#password", "9890909090");
		FEKeywords.clickOnElement("XPATH", FileUtil.getProperty("SignIn.remembermecheckbox"));
		FEKeywords.clickOnElement("XPATH", FileUtil.getProperty("SignIn.signinbutton"));
		String actualError=FEKeywords.getTextOfElement("XPATH",FileUtil.getProperty("SignIn.emailaddresserror"));
		String expectedError="These credentials do not match our records.";
		Assert.assertEquals(actualError, expectedError);
		log.info("If user enter invalid Email Adress then These"
				+ " credentials do not match our records error is displayed ");
	}
	
	/**
	 * For this method registered Email Address should be available.
	 */
	@Test
	public void verifyInvalidPasswordErrorTest() {
		FEKeywords.enterText("CSS", "input#email", "abcd@gmail.com");
		FEKeywords.enterText("CSS", "input#password", "9890909090");
		FEKeywords.clickOnElement("XPATH", FileUtil.getProperty("SignIn.remembermecheckbox"));
		FEKeywords.clickOnElement("XPATH", FileUtil.getProperty("SignIn.signinbutton"));
		String actualError=FEKeywords.getTextOfElement("XPATH",FileUtil.getProperty("SignIn.emailaddresserror"));
		String expectedError="These credentials do not match our records.";
		Assert.assertEquals(actualError, expectedError);
		log.info("If user enter invalid Email Adress then These"
				+ " credentials do not match our records error is displayed ");
	}
	
	
	
}
