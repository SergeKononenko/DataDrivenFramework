package com.serge.testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.serge.base.TestBase;

public class AddCustomer extends TestBase {

	@Test(dataProvider = "getData")
	public void addCustomer(String firstName, String lastName,
			String postalCode, String alertText) throws InterruptedException {

		driver.findElement(
				By.cssSelector(locators.getProperty("AddCustomerTab_css"))).click();
		driver.findElement(
				By.xpath(locators.getProperty("FirstNameInput_xpath"))).sendKeys(firstName);
		driver.findElement(
				By.xpath(locators.getProperty("LastNameInput_xpath"))).sendKeys(lastName);
		driver.findElement(
				By.xpath(locators.getProperty("PostalCode_xpath"))).sendKeys(postalCode);
		driver.findElement(
				By.cssSelector(locators.getProperty("AddCustomerButton_css"))).click();
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		Assert.assertTrue(alert.getText().contains(alertText));
		
		Thread.sleep(200);
		
		alert.accept();
		
		//Reporter.log("Success!"); //ReportNG Log
		
		Assert.fail("Not Real FAil");
		
		
		
		
	}

	@DataProvider
	public Object[][] getData() {

		String sheetName = "AddCustomer";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][cols];

		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			for (int colNum = 0; colNum < cols; colNum++) {

				// data[0][0]
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum,
						rowNum);

			}

		}

		return data;
	}

}
