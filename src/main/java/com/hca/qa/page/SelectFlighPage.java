package com.hca.qa.page;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class SelectFlighPage extends TestBase{
	
	@FindBy(xpath="//table[1]/tbody/tr[7]/td[@class='frame_action_xrows'][1]")
	WebElement rowforFlight;
	@FindBy(xpath="//table[2]/tbody/tr[7]/td[@class='frame_action_xrows']")
	WebElement rowforFlight2;
	
	@FindBy(xpath="//input[@name='reserveFlights']")
	WebElement continue_button;
	
	public SelectFlighPage() throws IOException{
		PageFactory.initElements(driver, this);
		
	}

	
	public void selectFlight() {
		
		rowforFlight.click();
		rowforFlight2.click();
		continue_button.click();
		
		
	}
}
