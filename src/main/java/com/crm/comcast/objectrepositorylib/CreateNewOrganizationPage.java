package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility
{
	WebDriver driver;

	public CreateNewOrganizationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement orgNameEdt;

	@FindBy(xpath = "//textarea[@name='description']/following::input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(name = "industry") 
	private WebElement industryListBox;
	
	@FindBy(name = "accounttype")
	private WebElement industryTypeListBox;
	
	

	public WebDriver getDriver()
	{
		return driver;
	}

	public WebElement getIndustryListBox()
	{
		return industryListBox;
	}

	public WebElement getIndustryTypeListBox()
	{
		return industryTypeListBox;
	}

	public WebElement getOrgNameEdt()
	{
		return orgNameEdt;
	}

	public WebElement getSaveButton()
	{
		return saveButton;
	}

	public void createOrganization(String orgName)
	{
		orgNameEdt.sendKeys(orgName);
		saveButton.click();   
	}
	
	public void createOrganization(String orgName, String industry,String industryType)
	{
		orgNameEdt.sendKeys(orgName);
		select(industryListBox, industry);
		select(industryTypeListBox, industryType);
		saveButton.click();   
	}
}
