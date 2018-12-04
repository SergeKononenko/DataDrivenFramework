package com.serge.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.serge.uilities.TestUtil;

public class CustomListeners implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {

		System.setProperty("org.uncommons.reportng.escape-output", "false");
		
		Reporter.log("<br>Capturing Screenshot ... ");
		
		TestUtil.cuptureScreenshot();
		
		Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName
				+ ">" + TestUtil.screenshotName + "</a><br>");
		
		Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName
				+ "><img src=" + TestUtil.screenshotName
				+ " height=200 width=400></img></a>");

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
