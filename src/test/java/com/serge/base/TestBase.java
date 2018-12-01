package com.serge.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
			fis = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\test\\resources\\properties\\Config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			config.load(fis);
			log.debug("Config file loaded!");
		} catch (IOException e) {
			e.printStackTrace();
		}

		locators = new Properties();
		try {
			fis = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\test\\resources\\properties\\Locators.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			locators.load(fis);
			log.debug("Locators file loaded!");
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (config.getProperty("browser").equals("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir")
							+ "\\src\\test\\resources\\executables\\gecko.exe");
			driver = new FirefoxDriver();
		} else if (config.getProperty("browser").equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", System
					.getProperty("user.dir")
					+ "\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (config.getProperty("browser").equals("ie")) {

			System.setProperty("webdriver.ie.driver", System
					.getProperty("user.dir")
					+ "\\src\\test\\resources\\executables\\IEDriverServer.exe");
			driver = new ChromeDriver();
		}

		driver.get(config.getProperty("mainPageURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(
				Integer.parseInt(config.getProperty("implicitWait")),
				TimeUnit.SECONDS);

	}

	@AfterSuite
	public void tearDown() {

		if (driver != null) {
			driver.quit();
		}
		log.debug("Test Suite completed.");
	}

	public boolean isElementPresent(By by) {

		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}

	}

	public static WebDriver driver;
	public static Properties config;
	public static Properties locators;
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
}
