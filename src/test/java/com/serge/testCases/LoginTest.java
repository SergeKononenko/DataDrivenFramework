package com.serge.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.serge.base.TestBase;

public class LoginTest extends TestBase {

	@Test
	public void loginAsManager() throws InterruptedException {

		log.debug("Inside Login test.");
		driver.findElement(
				By.xpath(locators.getProperty("ManagerLoginButton_xpath")))
				.click();

		Assert.assertTrue(
				isElementPresent(By.xpath(
						locators.getProperty("AddCustomerButton_xpath"))),
				"Login was not successful");

	}
}