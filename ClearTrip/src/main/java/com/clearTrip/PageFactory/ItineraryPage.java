package com.clearTrip.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.clearTrip.generic.EnvSetup;

public class ItineraryPage {

	private EnvSetup objEnvSetup;
	By loc_CheckBox_TermsAndConditions = By.xpath("//input[@id='insurance_confirm']");
	By loc_Btn_ContinueBooking = By.id("itineraryBtn");
	By loc_TextBox_EmailID = By.id("username");
	By loc_Btn_Continue = By.id("LoginContinueBtn_1");
	By loc_TextBox_Adult_FirstName = By.name("AdultFname1");
	

	public ItineraryPage(EnvSetup envSetup) {
		this.objEnvSetup = envSetup;
	}

	public void clickCheckBoxTermsAndConditions() {
		WebElement webelement = objEnvSetup.getDriver().findElement(loc_CheckBox_TermsAndConditions);
		webelement.click();
	}

	public void clickBtnContinueBooking() {
		WebElement webelement = objEnvSetup.getDriver().findElement(loc_Btn_ContinueBooking);
		webelement.click();
	}

	public void enterEmailId() {
		WebElement webelement = objEnvSetup.getDriver().findElement(loc_TextBox_EmailID);
		webelement.sendKeys("verve@sample.com");
	}

	public void clickBtnContinue() {
		WebElement webelement = objEnvSetup.getDriver().findElement(loc_Btn_Continue);
		webelement.click();
	}

	public void enterAdultOneFirstName() {
		WebElement webelement = objEnvSetup.getDriver().findElement(loc_TextBox_Adult_FirstName);

	}
}
