package com.serge.testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.serge.base.TestBase;
import com.serge.uilities.TestUtil;

public class AddCustomer extends TestBase {

	@Test(dataProviderClass=TestUtil.class, dataProvider="dp")
	public void addCustomer(String firstName, String lastName,
			String postalCode, String alertText) throws InterruptedException {

		click("AddCustomerTab_css");
		type("FirstNameInput_xpath", firstName);
		type("LastNameInput_xpath", lastName);
		type("PostalCode_xpath", postalCode);
		click("AddCustomerButton_css");
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		Assert.assertTrue(alert.getText().contains(alertText));
		alert.accept();
		
		//Reporter.log("Success!"); //ReportNG Log
		
		//Assert.fail("Not Real FAil");
		
		
		
		
	}

	

}
