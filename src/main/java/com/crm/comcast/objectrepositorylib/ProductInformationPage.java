package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage
{
	WebDriver driver;

	public ProductInformationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className ="lvtHeaderText")
	private WebElement productSucMsg;

	public WebElement getProductSucMsg()
	{
		return productSucMsg;
	}
}
