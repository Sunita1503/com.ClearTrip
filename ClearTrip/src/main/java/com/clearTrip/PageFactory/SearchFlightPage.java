package com.clearTrip.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.clearTrip.generic.EnvSetup;
import com.clearTrip.generic.Utilities;

public class SearchFlightPage {
		
	private EnvSetup  objEnvSetup;
	
	//Locator variables
	By loc_Link_Flights = By.xpath("//*[@id='Home']/div/aside[1]/nav/ul[1]/li[1]/a[1]");
	By loc_RadioBtn_RoundTrip = By.id("RoundTrip");
	By loc_Select_FromCity = By.id("FromTag");
	By loc_Select_ToCity = By.id("ToTag");
	By loc_DateofReturn = By.id("ReturnDate");
	By loc_DateofDepart = By.id("DepartDate");
	By loc_Select_Adults = By.id("Adults");
	By loc_Btn_Search = By.id("SearchBtn");
	
	
	public SearchFlightPage(EnvSetup envSetup){
		this.objEnvSetup = envSetup;
	}
	
	//Verify Title
	public void verifyPageTitle(){
		//get Title
		String strTitle = objEnvSetup.getDriver().getTitle();
		System.out.println("Title : " + strTitle);
		
		Assert.assertEquals(strTitle, "#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities.");
		
		// wait till 15 seconds
	    objEnvSetup.objUtilities.setImplicitWait(15);
		
		System.out.println("Title verified ");
	}
	
	
	//locate flights tab
	public void setFlight(){
				
		WebElement webelement = objEnvSetup.getDriver().findElement(loc_Link_Flights);
		webelement.click();
	}
	
	
	public void setRadioBtn(){
		WebElement webElement = objEnvSetup.getDriver().findElement(loc_RadioBtn_RoundTrip);
		webElement.click();
	}
	
	public void setFromCity(String strFromCity){
		WebElement webelement = objEnvSetup.getDriver().findElement(loc_Select_FromCity);
		webelement.sendKeys(strFromCity);
	}
	
	public void setToCity(String strToCity){
		WebElement webelement = objEnvSetup.getDriver().findElement(loc_Select_ToCity);
		webelement.sendKeys(strToCity);
	}
	
	public void setReturnDate(){
		WebElement webelement = objEnvSetup.getDriver().findElement(loc_DateofReturn);
		webelement.sendKeys(objEnvSetup.objUtilities.setReturnDate());		
	}
	
	public void setDepartDate(){
		WebElement webelement = objEnvSetup.getDriver().findElement(loc_DateofDepart);
		webelement.sendKeys(objEnvSetup.objUtilities.setDepartDate());
	}
	
	public void setAdults(){
		WebElement webelement = objEnvSetup.getDriver().findElement(loc_Select_Adults);
		List<WebElement> count = webelement.findElements(By.tagName("option"));
		count.get(1).click();
	}
	
	public void clickSearchBtn(){
		WebElement webelement = objEnvSetup.getDriver().findElement(loc_Btn_Search);
		webelement.click();
		objEnvSetup.objUtilities.setImplicitWait(20);
	}
}
