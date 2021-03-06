package com.serge.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.serge.base.TestBase;

public class LoginTest extends TestBase {

	@Test
	public void loginAsManager() throws InterruptedException {
		
		Thread.sleep(1000);
		verifyEquals("abc",	"xyz");
		
		log.debug("Inside Login test.");// Application log example

		click("ManagerLoginButton_css");

		Assert.assertTrue(isElementPresent("AddCustomerTab_css"),
				"Login was not successful");
		
		//Assert.fail("Login not successful");

	}
}