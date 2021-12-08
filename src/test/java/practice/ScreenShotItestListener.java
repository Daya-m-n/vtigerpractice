package practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.objectrepositorylib.HomePage;

@Listeners(com.crm.comcast.genericutility.ListenerImpClass.class)
public class ScreenShotItestListener extends BaseClass
{
	@Test
	public void test1()
	{
		HomePage hPage=new HomePage(driver);
		hPage.getOrganizationLink().click();
		String expectedTitle="dmnqwe";
		Assert.assertEquals(expectedTitle, driver.getTitle(), "Failed");
	}
}
