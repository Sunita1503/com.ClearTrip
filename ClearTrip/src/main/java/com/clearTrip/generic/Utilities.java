package com.clearTrip.generic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Utilities {

	private EnvSetup objEnvSetup;
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	

	public Utilities(EnvSetup envSetup) {
		this.objEnvSetup = envSetup;
	}

	// Java wait
	public boolean waitFor(int timeUnitSeconds) {
		try {
			Thread.sleep(TimeUnit.MILLISECONDS.convert(timeUnitSeconds, TimeUnit.SECONDS));
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	// Implicit Wait
	public void setImplicitWait(int timeUnitSeconds) {
		objEnvSetup.getDriver().manage().timeouts().implicitlyWait(timeUnitSeconds, TimeUnit.SECONDS);
	}

	// Set Depart Date 5 days from current Date
	public String setDepartDate() {
		//SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		// Getting current date
		Calendar cal = Calendar.getInstance();

		// Displaying current date in the desired format
		//System.out.println("Current Date: " + sdf.format(cal.getTime()));
		// 23-11-2020
		// Number of Days to add
		cal.add(Calendar.DAY_OF_MONTH, 5);
		// Date after adding the days to the current date
		String newDate = sdf.format(cal.getTime());
		// Displaying the new Date after addition of Days to current date
		System.out.println("Date after Addition: " + newDate);
		return newDate;
	}
	
	public String setReturnDate(){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 6);
		String newDate = sdf.format(cal.getTime());
		return newDate;
	}

}
