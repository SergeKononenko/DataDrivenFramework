package com.serge.uilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.serge.base.TestBase;

public class TestUtil extends TestBase {

	public static String screenshotPath;
	public static String screenshotName;

	public static final SimpleDateFormat format = new SimpleDateFormat(
			"yyyy_MM_dd_HH_mm_ss");

	String dateString;

	public static void cuptureScreenshot() {

		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		screenshotName = format.format(new Date()) + ".jpg";
		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")
					+ "\\screenshots\\" + screenshotName));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@DataProvider(name = "dp")
	public static Object[][] getData(Method m) {

		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][1];

		Hashtable<String, String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) {

			table = new Hashtable<String, String>();
			for (int colNum = 0; colNum < cols; colNum++) {

				table.put(excel.getCellData(sheetName, colNum, 1),
						excel.getCellData(sheetName, colNum, rowNum));

				// data[0][0]
//				 data[rowNum - 2][colNum] = excel.getCellData(sheetName,
//				 colNum,rowNum);
				data[rowNum - 2][0] = table;
			}

		}

		return data;
	}

	public static boolean isTestRunnable(String testName, ExcelReader excel) {

		String sheetName = "TestSuite";

		int rows = excel.getRowCount(sheetName);

		for (int rNum = 2; rNum <= rows; rNum++) {

			String testCase = excel.getCellData(sheetName, "TCID", rNum);
			if (testCase.equalsIgnoreCase(testName)) {
				String runMode = excel.getCellData(sheetName, "RunMode", rNum);
				if (runMode.equalsIgnoreCase("y"))
					return true;
				else
					return false;

			}

		}

		return false;

	}

}
