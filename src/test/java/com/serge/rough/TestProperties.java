package com.serge.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws IOException {

		Properties config = new Properties();
		FileInputStream confFile = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
		config.load(confFile);
		
		Properties OR = new Properties();
		FileInputStream orFile = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Locators.properties");
		OR.load(orFile);
		
		
		
		
	}

}
