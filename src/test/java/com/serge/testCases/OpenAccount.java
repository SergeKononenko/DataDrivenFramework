package com.serge.testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.serge.base.TestBase;
import com.serge.uilities.TestUtil;

public class OpenAccount extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void openAccount(String customer, String currency, String alertText)
			throws InterruptedException {

		click("openAccount_css");
		select("customer_css", customer);
		select("currency_css", currency);
		click("process_css");

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(alertText));
		alert.accept();

	}

}
