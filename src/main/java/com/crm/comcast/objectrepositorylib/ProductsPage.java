package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage
{
	WebDriver driver;

	public ProductsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement createProductImg;
	
	@FindBy(id = "search_txt")
	private WebElement productSearchBox;

	public WebElement getProductSearchBox()
	{
		return productSearchBox;
	}

	public WebElement getProductSearchButton()
	{
		return productSearchButton;
	}

	@FindBy(name = "search")
	private WebElement productSearchButton;

	public WebElement getCreateProductImg()
	{
		return createProductImg;
	}

}
