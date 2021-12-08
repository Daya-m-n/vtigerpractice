package com.crm.comcast.genericutility;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * It's contains webdriver specific reusable actions
 * 
 * @author Dayananda M N
 *
 */
public class WebDriverUtility
{

	/**
	 * Used to wait for page to load before identifying any synchronized element in
	 * DOM[HTML-Document]
	 * 
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * Used to wait for page to load before identifying any assynchronized[java
	 * scripts actions] element in DOM[HTML-Document]
	 * 
	 * @param driver
	 */
	public void waitForPageToLoadForJSElement(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	}

	/**
	 * Used to wait for element to be clickable in GUI, & check for specific element
	 * for every 500 milli seconds.
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Used to wait for element to be clickable in GUI & check for specific element
	 * for every pollingTime we specified
	 * 
	 * @param driver
	 * @param element
	 * @param pollingTime
	 * @throws Throwable
	 */
	public void waitForElementWithCustomTimeOut(WebDriver driver, WebElement element, int pollingTime) throws Throwable
	{
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
		wait.wait(20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Used to switch to any window based on window title.
	 * 
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWindowTitle)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while (it.hasNext())
		{
			String wid = it.next();
			driver.switchTo().window(wid);
			String currentWindowTitle = driver.getTitle();
			if (currentWindowTitle.contains(partialWindowTitle))
			{
				break;
			}
		}
	}

	/**
	 * This method is used to switch to alert window & click on Ok button
	 * 
	 * @param driver
	 */
	public void switchToAlertWindowAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}

	/**
	 * This method is used to switch to alert window & click on cancel button
	 * 
	 * @param driver
	 */
	public void switchToAlertWindowAndCancel(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}

	/**
	 * Used to switch to frame window based on index
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}

	/**
	 * Used to switch to frame window based on index
	 * 
	 * @param driver
	 * @param id_name_attribute
	 */
	public void switchToFrame(WebDriver driver, String id_name_attribute)
	{
		driver.switchTo().frame(id_name_attribute);
	}

	/**
	 * Used to select the value from the dropdown based on index
	 * 
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * Used to select the value from the dropdown based on value/ option available
	 * in GUI
	 * 
	 * @param element
	 * @param text
	 */
	public void select(WebElement element, String text)
	{
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/**
	 * Used to place mouse cursor on specified element
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseHoverOnElement(WebDriver driver, WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	/**
	 * This method is used to right click on specified element
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver, WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}

	/**
	 * This method is used to execute javascript code
	 * 
	 * @param driver
	 * @param javaScript
	 */
	public void executeJavaScript(WebDriver driver, String javaScript)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeAsyncScript(javaScript, null);
	}

	/**
	 * This method is used to click on a webelement
	 * 
	 * @param element
	 * @throws Throwable
	 */
	public void waitAndClick(WebElement element) throws Throwable
	{
		int count = 0;
		while (count < 20)
		{
			try
			{
				element.click();
				break;
			} catch (Exception e)
			{
				Thread.sleep(1000);
				count++;
			}
		}
	}

	/**
	 * This method is used to take screenshots
	 * 
	 * @param driver
	 * @param screenShotName
	 * @throws Throwable
	 */
	public void takeScreenShot(WebDriver driver, String screenShotName) throws Throwable
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/" + screenShotName + ".PNG");
		Files.copy(src, dest);
	}

	/**
	 * This method is used to press enter key
	 * @param driver
	 */
	public void passEnterKey(WebDriver driver)
	{
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
	}
}
