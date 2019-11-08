package com.hca.qa.page;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;




public class LoginpageTours extends TestBase{
	
	@FindBy(xpath="//input[@name='userName']")
	@CacheLookup                //-Improve Performance of the System
	WebElement userName;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	@FindBy(xpath="//input[@value='Login']")
	WebElement login;
	
	public LoginpageTours() throws IOException {
		PageFactory.initElements(driver, this);
		
	}

	
	
	public void login(String usrname,String paswrd) {
		
		userName.sendKeys(usrname);
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(paswrd);
		wait.until(ExpectedConditions.elementToBeClickable(login));
		
		login.click();
		
		
	}

}
