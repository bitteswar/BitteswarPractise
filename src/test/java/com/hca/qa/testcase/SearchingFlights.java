package com.hca.qa.testcase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hca.qa.page.FlightFinderPage;
import com.hca.qa.page.LoginpageTours;
import com.qa.base.TestBase;

public class SearchingFlights extends TestBase {

	LoginpageTours login;
	FlightFinderPage flight;

	public SearchingFlights() throws Exception {
		super();
	}

	@BeforeMethod
	public void luchingApplication() throws Exception {
		initialization();
		login = new LoginpageTours();
		flight=new FlightFinderPage();
		
		String username=prop.getProperty("userId");
		String password=prop.getProperty("password");
		login.login(username, password);
	}

	@Test

	public void serachingFlights() throws InterruptedException {
		
		
		Thread.sleep(4000);
		
		flight.selectFlightDetails(2, 6, "London", "Paris", 8);
		

	}

	@AfterMethod
	public void teardown() {

		driver.quit();
	}
}
