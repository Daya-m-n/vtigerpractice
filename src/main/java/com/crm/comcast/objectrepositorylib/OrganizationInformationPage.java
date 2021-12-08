package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage
{
	WebDriver driver;

	public OrganizationInformationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "dvHeaderText")
	private WebElement succesfulMsg;
	
	@FindBy(id="dtlview_Industry")
	private WebElement industrySucInfo;
	
	@FindBy(id="dtlview_Type")
	private WebElement industryTypeSucInfo;

	public WebElement getIndustrySucInfo()
	{
		return industrySucInfo;
	}

	public WebElement getIndustryTypeSucInfo()
	{
		return industryTypeSucInfo;
	}

	public WebDriver getDriver()
	{
		return driver;
	}

	public WebElement getSuccesfulMsg()
	{
		return succesfulMsg;
	}
}
