package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProduct
{
	WebDriver driver;

	public CreateNewProduct(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "productname")
	private WebElement productNameEdt;

	@FindBy(xpath = "//textarea[@name='description']/following::input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getSaveButton()
	{
		return saveButton;
	}

	public WebElement getProductNameEdt()
	{
		return productNameEdt;
	}

	public void createProduct(String productName)
	{
		productNameEdt.sendKeys(productName);
		saveButton.click();
	}
}
