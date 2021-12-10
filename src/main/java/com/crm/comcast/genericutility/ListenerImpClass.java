package com.crm.comcast.genericutility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImpClass implements ITestListener 
{
	
	
	public void onTestFailure(ITestResult result)
	{
		JavaUtility jlib=new JavaUtility();
		String testName = result.getMethod().getMethodName();
		EventFiringWebDriver eFDriver = new EventFiringWebDriver(BaseClass.sdriver);
		File srcFile = eFDriver.getScreenshotAs(OutputType.FILE);
		File destFile=new File("./screenshot/"+testName+jlib.getTimeDateFormat()+".png");
		try
		{
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e)
		{

			e.printStackTrace();
		}
	}

	
}
