package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage
{
	WebDriver driver;

	public ContactsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createcontactsImg;

	public WebDriver getDriver()
	{
		return driver;
	}

	public WebElement getCreatecontactsImg()
	{
		return createcontactsImg;
	}
	
	
}
