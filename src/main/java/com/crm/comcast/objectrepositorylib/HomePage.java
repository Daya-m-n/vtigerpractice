package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.comcast.genericutility.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
	WebDriver driver;

	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;

	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;

	@FindBy(linkText = "Products")
	private WebElement productsLink;

	@FindBy(linkText = "More")
	private WebElement moreLink;

	@FindBy(linkText = "Vendors")
	private WebElement vendorsLink;

	public WebElement getProductsLink()
	{
		return productsLink;
	}

	public WebElement getMoreLink()
	{
		return moreLink;
	}

	public WebElement getVendorsLink()
	{
		return vendorsLink;
	}

	public WebElement getPurchaseOrderLink()
	{
		return purchaseOrderLink;
	}

	@FindBy(linkText = "Purchase Order")
	private WebElement purchaseOrderLink;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstratorImg;

	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement logOutLink;

	public WebDriver getDriver()
	{
		return driver;
	}

	public WebElement getOrganizationLink()
	{
		return organizationLink;
	}

	public WebElement getAdminstratorImg()
	{
		return adminstratorImg;
	}

	public WebElement getLogOutLink()
	{
		return logOutLink;
	}

	public WebElement getContactsLink()
	{
		return contactsLink;
	}

	public void logout()
	{
		mouseHoverOnElement(driver, adminstratorImg);
		logOutLink.click();

	}

	public void clickVendorsLink()
	{
		mouseHoverOnElement(driver, moreLink);
		vendorsLink.click();
	}
	
	public void clickPurchaseOrderLink()
	{
		mouseHoverOnElement(driver, moreLink);
		purchaseOrderLink.click();
	}
}
