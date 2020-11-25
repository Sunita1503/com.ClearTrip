package com.clearTrip.generic;


import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.security.Credentials;
import org.testng.annotations.Test;

public class EnvSetup {

	public Utilities objUtilities;
	public WebDriver driver;
	public Properties objConfig;

	// set up initial environment
	
	public void initializeWebEnv() {

		// Launch Browser
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.cleartrip.com/");

		// implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		objUtilities = new Utilities(this);
		/*Alert objAlert = driver.switchTo().alert();
		
		objAlert.accept();*/
				
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	public void loadConfigProperties(){
		
		try {
			objConfig = new Properties();
			objConfig.load(new FileInputStream(System.getProperty("user.dir")+ "/src/main/resources/config.properties"));
						
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	
	public Utilities getUtility(){
		return objUtilities;
	}
}
