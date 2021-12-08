package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage
{
	WebDriver driver;

	public VendorsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@title='Create Vendor...']")
	private WebElement createVendorImg;

	@FindBy(id = "search_txt")
	private WebElement vendorSearchBox;

	@FindBy(name = "search")
	private WebElement vendorSearchButton;

	public WebElement getVendorSearchBox()
	{
		return vendorSearchBox;
	}

	public WebElement getVendorSearchButton()
	{
		return vendorSearchButton;
	}

	public WebDriver getDriver()
	{
		return driver;
	}

	public WebElement getCreateVendorImg()
	{
		return createVendorImg;
	}
}
