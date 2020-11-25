package com.clearTrip.scripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.clearTrip.PageFactory.ItineraryPage;
import com.clearTrip.PageFactory.SearchFlightPage;
import com.clearTrip.PageFactory.SearchResultPage;
import com.clearTrip.generic.EnvSetup;

public class FlightBookingTest extends EnvSetup{
	
	private SearchFlightPage objSearchFlight;
	private SearchResultPage objSearchResultPage;
	private ItineraryPage objItineraryPage;
	
	@BeforeTest
	public void initializeWebEnvironment(){	
		initializeWebEnv();
		objSearchFlight = new SearchFlightPage(this);	
		objSearchResultPage = new SearchResultPage(this);
		objItineraryPage = new ItineraryPage(this);
	}
	@Test
	public void TC_ID_01_BookFlight(){		
		objSearchFlight.verifyPageTitle();
		objSearchFlight.setFlight();
		objSearchFlight.setRadioBtn();
		/*objSearchFlight.setFromCity(objConfig.getProperty("To"));
		objSearchFlight.setToCity(objConfig.getProperty("From"));*/
		objSearchFlight.setFromCity("Mumbai");
		objSearchFlight.setToCity("Delhi");
		objSearchFlight.setDepartDate();
		objSearchFlight.setReturnDate();
		objSearchFlight.setAdults();
		objSearchFlight.clickSearchBtn();
		
		objSearchResultPage.setCheckBox();
		objSearchResultPage.selectDepartFlight();
		//objSearchResultPage.selectReturnFlight();
		objSearchResultPage.clickBtnBook();
		
	//	objItineraryPage.clickCheckBoxTermsAndConditions();
		objItineraryPage.clickBtnContinueBooking();
		objItineraryPage.enterEmailId();
		objItineraryPage.clickBtnContinue();
		
		
	}
}
