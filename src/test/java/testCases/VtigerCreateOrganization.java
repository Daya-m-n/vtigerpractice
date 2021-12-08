package testCases;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.SDET25.GenericUtils.ExcelUtility;
import com.crm.SDET25.GenericUtils.FileUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VtigerCreateOrganization 
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
		String date = LocalDateTime.now().toString();
		
		//Read the test data from excel sheet
		ExcelUtility eutil=new ExcelUtility();
		String organizationName = eutil.getExcelData("Sheet1", 3, 0);
		
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

		//Navigate to URL
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.get(URL);
		
		//Login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Navigate to organization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Enter the mandatory fields
		driver.findElement(By.name("accountname")).sendKeys(organizationName+date);
		
		//save
		driver.findElement(By.xpath("//textarea[@name='description']/following::input[@class='crmbutton small save']"))
				.click();
		
		//signout
		Actions actions = new Actions(driver);
		driver.navigate().refresh();
		actions.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}
}
