package com.hca.qa.testcase;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hca.qa.page.FlightFinderPage;
import com.hca.qa.page.LoginpageTours;
import com.hca.qa.page.SelectFlighPage;
import com.qa.base.TestBase;

public class SelectingFlightsFromTable extends TestBase {
	LoginpageTours login;
	FlightFinderPage flight;
	SelectFlighPage selctflight;

	public SelectingFlightsFromTable() throws IOException {
		super();

		
		

	}

	@BeforeMethod
	public void luchingApplication() throws Exception {
		initialization();
		login = new LoginpageTours();
		flight = new FlightFinderPage();
		selctflight = new SelectFlighPage();

		String username = prop.getProperty("userId");
		String password = prop.getProperty("password");
		login.login(username, password);
	}

	@Test

	public void seletingFlightfrmlist() throws InterruptedException {

		flight.selectFlightDetails(2, 6, "London", "Paris", 8);

		selctflight.selectFlight();

	}

	@AfterMethod
	public void teardown() {

		driver.quit();

	}
}
