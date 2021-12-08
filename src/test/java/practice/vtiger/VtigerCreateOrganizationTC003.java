package practice.vtiger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.SDET25.GenericUtils.FileUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VtigerCreateOrganizationTC003
{
	@Test
	public void vtigerCreateOrganization() throws Throwable
	{
		WebDriver driver = null;
		//Read the common data from property file
		FileUtility flib = new FileUtility();
		String BROWSER = flib.readDataFromPropertyFile("browser");
		String URL = flib.readDataFromPropertyFile("url");
		String USERNAME = flib.readDataFromPropertyFile("username");
		String PASSWORD = flib.readDataFromPropertyFile("password");

		//Launch the browser
		if (BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else {
			System.out.println("Invalid Browsername");
		}

		//Navigate to the url
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.get(URL);
		
		//Login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Store the parent window id
		String wid = driver.getWindowHandle();
		
		//Navigate to contacts
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		////Enter the mandatory fields
		driver.findElement(By.name("lastname")).sendKeys("Dayanand");
		driver.findElement(By.xpath("//img[contains(@onclick,'return window')]")).click();

		// Switching control to child window
		List<String> wids = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(wids.get(1));
        driver.findElement(By.xpath("//a[text()='TYSS']")).click();
		
		// switching back control from child window to parent window
		driver.switchTo().window(wid);
		
		//save
		driver.findElement(By.xpath("//textarea[@name='description']/following::input[@class='crmbutton small save']"))
				.click();
		
		//Sign out
		Actions actions = new Actions(driver);
		driver.navigate().refresh();
		actions.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}
}
