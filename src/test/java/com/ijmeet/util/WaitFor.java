package com.ijmeet.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class WaitFor {
	/**
	 * Minimum time is 10 seconds
	 */

	public static void minTime() {
		Constant.wait.withTimeout(10,TimeUnit.SECONDS);
		Constant.wait.pollingEvery(200, TimeUnit.MILLISECONDS);
	}
	
	/**
	 * Moderate time is 20 seconds
	 */

	public static void moderateTime() {
		Constant.wait.withTimeout(20,TimeUnit.SECONDS);
		Constant.wait.pollingEvery(200, TimeUnit.MILLISECONDS);
	}
	/**
	 * Maximum time is 50 seconds
	 */

	public static void maxTime() {
		Constant.wait.withTimeout(50,TimeUnit.SECONDS);
		Constant.wait.pollingEvery(200, TimeUnit.MILLISECONDS);

	}
	/**
	 * 
	 * Wait for 10 seconds until element visible.
	 */

	public void elementToBeVisible(WebElement element) {
		Constant.wait.withTimeout(10,TimeUnit.SECONDS);
		Constant.wait.until(ExpectedConditions.visibilityOf(element));
		Constant.wait.pollingEvery(200, TimeUnit.MILLISECONDS);

	}


}
