package com.serge.testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.serge.base.TestBase;

public class AddCustomer extends TestBase {

	@Test(dataProvider = "getData")
	public void addCustomer(String firstName, String lastName,
			String postalCode, String alertText) throws InterruptedException {

		click("AddCustomerTab_css");
		type("FirstNameInput_xpath", firstName);
		type("LastNameInput_xpath", lastName);
		type("PostalCode_xpath", postalCode);
		click("AddCustomerButton_css");
		
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
