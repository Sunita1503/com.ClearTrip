package com.clearTrip.PageFactory;

import org.testng.annotations.Test;

import com.clearTrip.generic.EnvSetup;

import org.testng.annotations.BeforeTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

public class FlightBooking_new {

	WebDriver driver;
	
	private EnvSetup  objEnvSetup;
	
	public FlightBooking_new(EnvSetup envSetup){
		this.objEnvSetup = envSetup;
		
	}
	
	@BeforeTest
	public void beforeTest() {

		// Launch Browser
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");
	
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.cleartrip.com/");

		// implicit wait
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public  void TCFlights() {

		
		
		// Locate Flights tab
		driver.findElement(By.xpath("//*[@id='Home']/div/aside[1]/nav/ul[1]/li[1]/a[1]")).click();

		// Locate RountTrip Radio button
		driver.findElement(By.id("RoundTrip")).click();

		// Locate From textbox for Mumbai
		driver.findElement(By.id("FromTag")).sendKeys("Mumbai");

		// Locate To for Delhi
		driver.findElement(By.id("ToTag")).sendKeys("Delhi");

		// select depart date
		// System.out.println(
		// driver.findElement(By.id("DepartDate")).getText());
		Date objDate = new Date();
		SimpleDateFormat objSDF = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println("Current Date is  " + objSDF.format(objDate));

		driver.findElement(By.id("DepartDate")).sendKeys("21-11-2020");;
		driver.findElement(By.id("ReturnDate")).sendKeys("30-11-2020");;

		// Select Adults dropdown for 2 persons
		WebElement adultsCount = driver.findElement(By.id("Adults"));
		List<WebElement> count = adultsCount.findElements(By.tagName("option"));
		count.get(1).click();
		//System.out.println("No. of persons selected are " + count.get(1).getText());
		

		// Click on Search Button
		driver.findElement(By.id("SearchBtn")).click();
		 
		 //implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		System.out.println("Search Page Loading");
		
		driver.findElement(By.xpath("//p[text()='Non-stop']")).click();
		

	}

/*	@AfterTest
	public void afterTest() {

		// driver.close();
	}
*/
}
