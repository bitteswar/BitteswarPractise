package com.qa.base;

 import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.hca.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public EventFiringWebDriver e_driver;
	public WebEventListener eventListner;

	public TestBase()  {
		try {
			prop = new Properties();
			FileInputStream fl = new FileInputStream(
					"C:\\Users\\HP15 BA022AX\\Desktop\\Bitteswar Selenium Practice\\BittuWork1\\"
							+ "BitteswarPractise\\src\\main\\java\\com\\hca\\qa\\config\\config.properties");

			prop.load(fl);
		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void initialization() throws Exception {

		String BrowserName = prop.getProperty("Browser");
		String URL=prop.getProperty("url4");
		if (BrowserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\HP15 BA022AX\\Desktop\\Bitteswar Selenium Practice\\BittuWork1\\BitteswarPractise\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (BrowserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\HP15 BA022AX\\Desktop\\Bitteswar Selenium Practice\\BittuWork1\\BitteswarPractise\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if (BrowserName.equals("IE")) {

			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\HP15 BA022AX\\Desktop\\Bitteswar Selenium Practice\\BittuWork1\\BitteswarPractise\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}
		    e_driver=new EventFiringWebDriver(driver);
		    eventListner=new WebEventListener();
		    e_driver.register(eventListner);
		    driver=e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		

	}

}
