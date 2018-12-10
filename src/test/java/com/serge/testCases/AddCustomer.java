package com.serge.testCases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.serge.base.TestBase;
import com.serge.uilities.TestUtil;

public class AddCustomer extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void addCustomer(Hashtable<String, String> data)
			throws InterruptedException {

		String postalCode = null;
		String post = data.get("postalCode");
		if (post.endsWith(".0"))
			postalCode = post.substring(0, post.length() - 2);

		click("AddCustomerTab_css");
		type("FirstNameInput_xpath", data.get("firstName"));
		type("LastNameInput_xpath", data.get("lastName"));
		type("PostalCode_xpath", postalCode);
		click("AddCustomerButton_css");

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());

		Assert.assertTrue(alert.getText().contains(data.get("alertText")));
		alert.accept();

		// Reporter.log("Success!"); //ReportNG Log

		// Assert.fail("Not Real FAil");
		// Thread.sleep(100);

	}

}
