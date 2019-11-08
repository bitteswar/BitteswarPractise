package com.hca.qa.page;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class FlightFinderPage extends TestBase {
	
	@FindBy(xpath = "//input[@type='radio'and @name='tripType' and @value='oneway'] ")
	WebElement radiobutton_oneway;
	@FindBy(xpath = "//select[@name='passCount']")
	WebElement pass_count;
	@FindBy(xpath = "//select[@name='fromMonth'] ")
	WebElement month_selector;
	@FindBy(xpath = "//select[@name='fromDay']")
	WebElement date_select;
	@FindBy(xpath = "//select[@name='fromPort']")
	WebElement departing_from;
	@FindBy(xpath = "//select[@name='toPort']")
	WebElement arriving_to;
	@FindBy(xpath = "//input[@value='Business']")
	WebElement buisness_radio;
	@FindBy(xpath = "//select[@name='airline']")
	WebElement preference_airlines;
	@FindBy(xpath = "//select[@name='toMonth']")
	WebElement month_selector_to;
	
	@FindBy(xpath = "//select[@name='toDay']")
	WebElement date_selector_to;
	
	@FindBy(xpath="//input[@name='findFlights']")
	WebElement submitt;

	public FlightFinderPage() throws IOException {
		PageFactory.initElements(driver, this);

	}

	
	
	public void selectFlightDetails(int count, int month, String staringLoc, String Arrivingloc,int tomonth) throws InterruptedException {
		
		
		radiobutton_oneway.click();

		Select passcount = new Select(pass_count);

		passcount.selectByValue(Integer.toString(count));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		month_selector.click();
		Select Month = new Select(month_selector);

		Month.selectByIndex(month);

		Select day = new Select(date_select);
		day.selectByIndex(2);
		departing_from.click();
		List<WebElement> Departfrom = driver.findElements(By.xpath("//select[@name='fromPort']/option"));

		for (int i = 0; i <= Departfrom.size(); i++) {

			String Placename = Departfrom.get(i).getText();

			if (Placename.equalsIgnoreCase(staringLoc)) {
				Departfrom.get(i).click();
				break;

			}
		}

		arriving_to.click();
		List<WebElement> Arrivingto = driver.findElements(By.xpath("//select[@name='toPort']//option"));

		for (int i = 0; i <= Arrivingto.size(); i++) {

			String Placename = Arrivingto.get(i).getText();

			if (Placename.equalsIgnoreCase(Arrivingloc)) {
				Arrivingto.get(i).click();
				break;

			}
		}

		Select Month1 = new Select(month_selector_to);

		Month1.selectByIndex(month);

		Select day1 = new Select(date_select);
		day1.selectByIndex(2);
		buisness_radio.click();
		
		Select prefairline=new Select(preference_airlines);
		
		prefairline.selectByIndex(3);
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(submitt));
		submitt.click();
		Thread.sleep(2000);
		
		
		
	}
}
