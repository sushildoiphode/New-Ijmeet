package com.ijmeet.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ijmeet.keywords.Keywords;

public class TestCasesListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("On Test Start");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("On Test Success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("On Test Failure. Screen shot will save in folder");
		Keywords.getScreenShot();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("On Test Skipped");		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("On Test Failed But Within Success Percentage");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("On Test Start with content");		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("On Test Finish");		
	}
	
	

}
