package practice.handlingCalenderPopup;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * To select today's date
 * @author Slim
 *
 */
public class SelectTodayDate
{
	@Test
	public void getDate()
	{
		LocalDateTime todayDate = LocalDateTime.now();
		String monthName = todayDate.getMonth().name();
		String modifiedMonthName = monthName.substring(0, 1) + monthName.substring(1).toLowerCase();
		int day = todayDate.getDayOfMonth();
		int year = todayDate.getYear();
		String monthAndYear = modifiedMonthName + " " + year;

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.ixigo.com/");
		driver.findElement(By.xpath("//input[@placeholder='Depart']")).click();
		String path = "//div[text()='" + monthAndYear + "']/ancestor::div[@class='rd-month']/descendant::div[text()='"
				+ day + "']";
		driver.findElement(By.xpath(path)).click();

	}
}
