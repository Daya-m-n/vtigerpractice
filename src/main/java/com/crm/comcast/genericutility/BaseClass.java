package com.crm.comcast.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.comcast.objectrepositorylib.HomePage;
import com.crm.comcast.objectrepositorylib.LoginPage;

public class BaseClass
{
	public WebDriver driver = null;
	public ExcelUtility eLib = new ExcelUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public JavaUtility jLib = new JavaUtility();
	public FileUtility fLib = new FileUtility();
	public static WebDriver sdriver;
	

	@BeforeSuite(groups= {"Smoke","Regression"})
	public void db_Connection()
	{
		System.out.println("=====database connection establisted========");
	}

	@Parameters("BROWSER")
	@BeforeClass(groups= {"Smoke","Regression"})
	public void launchBrowser(/* String BROWSER */ ) throws Throwable
	{

		String BROWSER = fLib.getPropertyKeyValue("browser");

		/* Launch the browser */

		if (BROWSER.equals("chrome"))
		{
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox"))
		{
			driver = new FirefoxDriver();
		} else
		{
			driver = new ChromeDriver();
		}
		sdriver=driver;
		
		wLib.waitForPageToLoad(driver);
		driver.manage().window().maximize();

	}

	@BeforeMethod(groups= {"Smoke","Regression"})
	public void loginToApplication() throws Throwable
	{
		String URL = fLib.getPropertyKeyValue("url");
		String UESRNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		LoginPage lP = new LoginPage(driver);
		lP.loginToApp(URL, UESRNAME, PASSWORD);
	}

	@AfterMethod(groups= {"Smoke","Regression"})
	public void logoutFromApplication()
	{
		HomePage hP = new HomePage(driver);
		hP.logout();
	}

	@AfterClass(groups= {"Smoke","Regression"})
	public void closeTheBrowser()
	{
		driver.quit();
	}

	@AfterSuite(groups= {"Smoke","Regression"})
	public void closeTheDataBase()
	{
		System.out.println("=========DaseBase closed=========");
	}
}
