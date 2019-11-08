package com.hca.qa.util;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import com.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	 public void takescreenshotAtendoftheStep() throws IOException {
		 TakesScreenshot scrShot =((TakesScreenshot)driver);
		 File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		
		 //Move image file to new destination
		 String currentdir=System.getProperty("user.dir");

         File DestFile=new File(currentdir+"//screenshot//"+System.currentTimeMillis()+".png");
       //Copy file at destination
         
         FileUtils.copyFile(SrcFile, DestFile);
		 
	 }

}
