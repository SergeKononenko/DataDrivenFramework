package com.serge.uilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

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
					+ "\\target\\surefire-reports\\html\\" + screenshotName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
