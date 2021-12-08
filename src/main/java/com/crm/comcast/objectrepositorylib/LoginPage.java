package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	WebDriver driver;
	 
	@FindBy(name = "user_name")
	private WebElement userNameEdt;

	@FindBy(name = "user_password")
	private WebElement userPasswordEdt;

	@FindBy(id = "submitButton")
	private WebElement loginButton;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserNameEdt()
	{
		return userNameEdt;
	}

	public WebElement getUserPasswordEdt()
	{
		return userPasswordEdt;
	}

	public WebElement getLoginButton()
	{
		return loginButton;
	}

	public void loginToApp(String url,String username,String password)
	{
		driver.get(url);
		userNameEdt.sendKeys(username);
		userPasswordEdt.sendKeys(password);
		loginButton.click();
	}
}
