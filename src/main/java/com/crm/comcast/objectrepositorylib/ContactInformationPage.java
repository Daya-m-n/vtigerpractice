package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage
{
	WebDriver driver;

	public ContactInformationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "dvHeaderText")
	private WebElement successfulMsg;
	
	@FindBy(id = "dtlview_Support Start Date")
	private WebElement supportDateSucInfo;
	
	@FindBy(id = "dtlview_Mobile")
	private WebElement mobileNoSucInfo;

	public WebElement getSupportDateSucInfo()
	{
		return supportDateSucInfo;
	}

	public WebElement getMobileNoSucInfo()
	{
		return mobileNoSucInfo;
	}

	public WebElement getSuccessfulMsg()
	{
		return successfulMsg;
	}

}
