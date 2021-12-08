package testScripts;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContacts
{
	public static void main(String[] args) throws Throwable
	{
		
		// Read common data from properties file
		FileInputStream fis = new FileInputStream("./data/CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");

		// Read test data from excel file
		FileInputStream file = new FileInputStream("./data/Book1.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		String lastName = workbook.getSheet("Sheet1").getRow(5).getCell(0).getStringCellValue();
		workbook.close();

		// Launch browser
		WebDriver driver = null;/* We can'nt use local variables without initialization */
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

		// Navigate to application
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);

		// Login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// Store the parent window id
		String wid = driver.getWindowHandle();

		// Navigate to contacts
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		// Enter the mandatory fields
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//img[contains(@onclick,'return window')]")).click();

		// Switching control to child window
		List<String> wids = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(wids.get(1));
		driver.findElement(By.xpath("//a[text()='TYSS']")).click();

		// switching back control from child window to parent window
		driver.switchTo().window(wid);

		// save
		driver.findElement(By.xpath("//textarea[@name='description']/following::input[@class='crmbutton small save']"))
				.click();

		// Sign out

		Actions actions = new Actions(driver);
		driver.navigate().refresh();
		actions.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
}
