package com.serge.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	@BeforeSuite
	public void setUp() {

		config = new Properties();
		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			config.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		locators = new Properties();
		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Locators.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			locators.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (config.getProperty("browser").equals("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\gecko.exe");
			driver = new FirefoxDriver();
		} else if (config.getProperty("browser").equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chrome.exe");
			driver = new ChromeDriver();
		}

	}

	@AfterSuite
	public void tearDown() {

	}

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties locators = new Properties();
	public static FileInputStream fis;
}
