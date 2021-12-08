package practice.handlingCalenderPopup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * To select any date on calender
 * @author Dayananda M N
 *
 */
public class SelectAnyDate
{
	@Test
	public void getDate()
	{
		int day = 20;
		String monthAndYear = "February 2022";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.ixigo.com/");
		driver.findElement(By.xpath("//input[@placeholder='Depart']")).click();
		String path = "//div[text()='" + monthAndYear + "']/ancestor::div[@class='rd-month']/descendant::div[text()='"
				+ day + "']";

		for (;;)
		{
			try
			{
				driver.findElement(By.xpath(path)).click();
				break;
			} catch (Exception e)
			{
				driver.findElement(By.xpath("//button[@class='ixi-icon-arrow rd-next']")).click();
			}
		}

	}
}
