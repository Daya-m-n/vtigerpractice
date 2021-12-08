package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage
{
	WebDriver driver;
	public OrganizationsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrgImg;
	
	@FindBy(id="search_txt")
	private WebElement orgSearchBox;
	
	@FindBy(name ="search")
	private WebElement orgSearchButton;
	
	public WebElement getOrgSearchBox()
	{
		return orgSearchBox;
	}

	public WebElement getOrgSearchButton()
	{
		return orgSearchButton;
	}

	public WebDriver getDriver()
	{
		return driver;
	}

	public WebElement getCreateOrgImg()
	{
		return createOrgImg;
	}

	
}
