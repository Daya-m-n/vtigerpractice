package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVendor
{
	WebDriver driver;

	public CreateNewVendor(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "vendorname")
	private WebElement venderNameEdt;

	@FindBy(xpath = "//textarea[@name='description']/following::input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getVenderNameEdt()
	{
		return venderNameEdt;
	}

	public WebElement getSaveButton()
	{
		return saveButton;
	}

	public void createVendor(String vendorName)
	{
		venderNameEdt.sendKeys(vendorName);
		saveButton.click();
	}
}
