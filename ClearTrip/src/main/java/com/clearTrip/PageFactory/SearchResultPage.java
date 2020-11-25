package com.clearTrip.PageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.clearTrip.generic.EnvSetup;

public class SearchResultPage {

	private EnvSetup objEnvSetup;
	
	By loc_CheckBox_Stops = By.xpath("//p[text()='Non-stop']");
	By loc_Select_DepartFlight = By.xpath("//*[@id=\"root\"]/div/main/div/div/div[2]/div[2]/div[12]/div[1]/div[1]/div/div[21]/div[1]");
	By loc_Select_ReturnFlight = By.xpath("//*[@id=\"root\"]/div/main/div/div/div[2]/div[2]/div[10]/div[2]/div[1]/div/div[6]");
	By loc_Btn_Book = By.xpath("//*[@id=\"root\"]/div/main/div/div[1]/div[2]/div[2]/div[7]/div/div[2]/button");
	
	public SearchResultPage(EnvSetup envSetup) {
		this.objEnvSetup = envSetup;
	}

	public void setCheckBox() {
		WebElement webelement = objEnvSetup.getDriver().findElement(loc_CheckBox_Stops);
		webelement.click();
		objEnvSetup.objUtilities.setImplicitWait(10);
	}

	public void selectDepartFlight() {
		WebElement webelement = objEnvSetup.getDriver().findElement(loc_Select_DepartFlight);
		webelement.click();
		objEnvSetup.objUtilities.setImplicitWait(10);
	}

	public void selectReturnFlight() {
		WebElement webelement = objEnvSetup.getDriver().findElement(loc_Select_ReturnFlight);
		webelement.click();
		objEnvSetup.objUtilities.setImplicitWait(10);
	}

	public void clickBtnBook() {
		WebElement webelement = objEnvSetup.getDriver().findElement(loc_Btn_Book);
		webelement.click();
		objEnvSetup.objUtilities.setImplicitWait(15);
	}

}
