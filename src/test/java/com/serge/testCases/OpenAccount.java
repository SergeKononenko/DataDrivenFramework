package com.serge.testCases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.serge.base.TestBase;
import com.serge.uilities.TestUtil;

public class OpenAccount extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void openAccount(Hashtable<String, String> data)
			throws InterruptedException {

		if (!data.get("RunMode").equalsIgnoreCase("y")) {
			throw new SkipException("Skipping test: due to RunMode is NO");
		}

		click("openAccount_css");
		select("customer_css", data.get("Customer"));
		select("currency_css", data.get("Currency"));
		click("process_css");

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(data.get("alertText")));
		alert.accept();

	}

}
