package com.serge.listeners;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;
import com.serge.base.TestBase;
import com.serge.uilities.SendEmail;
import com.serge.uilities.TestConfig;
import com.serge.uilities.TestUtil;

public class CustomListeners extends TestBase
		implements ITestListener, ISuiteListener {

	public void onTestStart(ITestResult result) {

		test = rep.startTest(result.getName().toUpperCase());

		// runmodes - y or n

		if (!TestUtil.isTestRunnable(result.getName(), excel)) {
			throw new SkipException(
					"Skipping test: " + result.getName().toUpperCase()
							+ ", due to RunMode is NO");
		}
	}

	public void onTestSuccess(ITestResult result) {

		test.log(LogStatus.PASS,
				result.getName().toUpperCase() + "Test passed");
		rep.endTest(test);
		rep.flush();

	}

	public void onTestFailure(ITestResult result) {

		TestUtil.cuptureScreenshot();

		// Extent log
		test.log(LogStatus.FAIL, result.getName().toUpperCase() + "Test Failed:"
				+ result.getThrowable());
		test.log(LogStatus.FAIL,
				test.addScreenCapture(System.getProperty("user.dir")
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
				+ System.getProperty("user.dir") + "\\screenshots\\"
				+ TestUtil.screenshotName + " height=200 width=400></img></a>");

		rep.endTest(test);
		rep.flush();

	}

	public void onTestSkipped(ITestResult result) {

		test.log(LogStatus.SKIP,
				result.getName().toUpperCase() + " Test Skipped!");
		rep.endTest(test);
		rep.flush();
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

	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ISuite suite) {

		SendEmail mail = new SendEmail();

		try {
			messageBody = "Test Suite Finished @ - " + new Date() + "\nhttp://"
					+ InetAddress.getLocalHost().getHostAddress()
					+ ":8080/job/DataDrivenProjectLive/Extent_20Report/";
		} catch (UnknownHostException e) {

			e.printStackTrace();
		}

		mail.sendFromGMailTLS(TestConfig.from, TestConfig.to,
				TestConfig.subject, messageBody);

	}

	public String messageBody;
}
