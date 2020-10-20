package com.ijmeet.base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.ijmeet.keywords.Keywords;

public class TestBase {
	@BeforeClass
	public void openBrowser() throws InterruptedException {
	
		Keywords.openBrowser("chrome");
		Keywords.launchUrl("https://ijmeet.com/");
		Thread.sleep(3000);
	}
	@AfterClass
	public void closeBrowser() {
		Keywords.closeBrowser();
		Keywords.quitBrowser();
	}
	
	

}
