package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility
{
	WebDriver driver;

	public CreateNewContactPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "lastname")
	private WebElement lastNameEdt;

	@FindBy(xpath = "//input[@name='lastname']/preceding::input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	@FindBy(id = "mobile")
	private WebElement moblieEdt;
	
	@FindBy(name ="support_end_date")
	private WebElement dateEdt;
	
	@FindBy(xpath = "//input[@name='account_id']/following-sibling::img")
	private WebElement orgName_LookupImg;
	
	public WebElement getOrgName_LookupImg()
	{
		return orgName_LookupImg;
	}

	public WebElement getMoblieEdt()
	{
		return moblieEdt;
	}

	public WebElement getDateEdt()
	{
		return dateEdt;
	}

	public WebDriver getDriver()
	{
		return driver;
	}

	public WebElement getLastNameEdt()
	{
		return lastNameEdt;
	}

	public WebElement getSaveButton()
	{
		return saveButton;
	}

	public void creatContact(String lastName)
	{
		lastNameEdt.sendKeys(lastName);
		saveButton.click();
	}
	
	public void creatContact(String lastName,String mobileNumber,String date)
	{
		lastNameEdt.sendKeys(lastName);
		moblieEdt.sendKeys(mobileNumber);
		dateEdt.clear(); 
		dateEdt.sendKeys(date);
		saveButton.click();
	}
	 
	public void creatContact(String lastName,String orgNAme)
	{
		lastNameEdt.sendKeys(lastName);
		getOrgName_LookupImg().click();
		switchToWindow(driver, "Accounts");
		OrganizationsPage oPage=new OrganizationsPage(driver);
		oPage.getOrgSearchBox().sendKeys(orgNAme);
		oPage.getOrgSearchButton().click();
		driver.findElement(By.xpath("//a[text()='"+orgNAme+"']")).click();
		switchToWindow(driver, "Contacts");
		saveButton.click();
	}
	
}
