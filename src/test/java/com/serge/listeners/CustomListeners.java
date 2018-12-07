package com.serge.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;
import com.serge.base.TestBase;
import com.serge.uilities.TestUtil;

public class CustomListeners extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {

		test = rep.startTest(result.getName().toUpperCase());

	}

	public void onTestSuccess(ITestResult result) {

		test.log(LogStatus.PASS,
				result.getName().toUpperCase() + "Test passed");
		rep.endTest(test);
		rep.flush();

	}

	public void onTestFailure(ITestResult result) {

		System.setProperty("org.uncommons.reportng.escape-output", "false");
		TestUtil.cuptureScreenshot();

		// Extent log
		test.log(LogStatus.FAIL, result.getName().toUpperCase() + "Test Failed:"
				+ result.getThrowable());
		test.log(LogStatus.FAIL,
				test.addScreenCapture( System.getProperty("user.dir")
						+ "\\screenshots\\" + TestUtil.screenshotName));

		// ReportNg
		Reporter.log("<br><br>Click to see Screenshot ... ");

		Reporter.log(
				"<a target=\"_blank\" href=" + System.getProperty("user.dir")
						+ "\\screenshots\\" + TestUtil.screenshotName + ">"
						+ TestUtil.screenshotName + "</a><br>");
		Reporter.log("<a target=\"_blank\" href="
				+ System.getProperty("user.dir") + "\\screenshots\\"
				+ TestUtil.screenshotName + "><img src="
				+  System.getProperty("user.dir") + "\\screenshots\\"
				+ TestUtil.screenshotName + " height=200 width=400></img></a>");

		rep.endTest(test);
		rep.flush();

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
