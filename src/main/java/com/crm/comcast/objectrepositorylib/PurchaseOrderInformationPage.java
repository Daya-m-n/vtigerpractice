package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrderInformationPage
{
	WebDriver driver;

	public PurchaseOrderInformationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "lvtHeaderText")
	private WebElement purchaseOrderSucMsg;

	public WebElement getPurchaseOrderSucMsg()
	{
		return purchaseOrderSucMsg;
	}
}
