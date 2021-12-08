package com.crm.comcast.purchaseorderTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.FileUtility;
import com.crm.comcast.genericutility.JavaUtility;
import com.crm.comcast.genericutility.WebDriverUtility;

public class CreatePurchaseOrderWithItem
{
	@Test
	public void createPurchaseOrderWithItem() throws Throwable
	{
		WebDriver driver = null;

		JavaUtility jlib = new JavaUtility();
		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		/* Get the Random data */
		int randomNum = jlib.getRandomNumber();

		/* Get the commondata from properties file */
		String BROWSER = flib.getPropertyKeyValue("browser");
		String URL = flib.getPropertyKeyValue("url");
		String USERNAME = flib.getPropertyKeyValue("username");
		String PASSWORD = flib.getPropertyKeyValue("password");

		/* Get the test data From excel file */
		String subject = elib.getDataFromExcel("PurchaseOrder", 1, 3) + randomNum;
		String product = elib.getDataFromExcel("PurchaseOrder", 1, 5) + randomNum;

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

		driver.manage().window().maximize();
		wlib.waitForPageToLoad(driver);
		driver.get(URL);

		/* Login to the application */
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		/* create product */
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(product);
		driver.findElement(By.xpath("//textarea[@name='description']/following::input[@title='Save [Alt+S]']")).click();

		/* Select purchase order */
		WebElement moreElement2 = driver.findElement(By.xpath("//a[text()='More']"));
		wlib.mouseHoverOnElement(driver, moreElement2);
		driver.findElement(By.linkText("Purchase Order")).click();
		driver.findElement(By.xpath("//img[@title='Create Purchase Order...']")).click();

		driver.findElement(By.name("subject")).sendKeys(subject);
		driver.findElement(By.id("searchIcon1")).click();

		/* Select product */
		wlib.switchToWindow(driver, "Products");
		driver.findElement(By.id("search_txt")).sendKeys(product);
		driver.findElement(By.xpath("//a[text()='"+ product +"']")).click();

		/* switching back to create purchase order page */
		wlib.switchToWindow(driver, "Purchase Order");
		
		/*verifying*/
		WebElement ele = driver.findElement(By.id("productName1"));
		String itemName=ele.getAttribute("value");
		if (itemName.contains(product))
		{
			System.out.println(product+" is selected:PASS");
		} else
		{
			System.out.println(product+" is not selected:FAIL");
		}
		/* Logout */
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
}
