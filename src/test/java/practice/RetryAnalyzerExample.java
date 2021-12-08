package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.objectrepositorylib.ContactsPage;
import com.crm.comcast.objectrepositorylib.CreateNewContactPage;
import com.crm.comcast.objectrepositorylib.HomePage;

public class RetryAnalyzerExample extends BaseClass
{
	@Test(retryAnalyzer =  com.crm.comcast.genericutility.RetryAnalyserImpClass.class)
	
	public void createContact() throws Throwable
	{
		/*Read the from excel */
		String contactName=eLib.getDataFromExcel("Contact", 1, 2)+jLib.getRandomNumber();
		HomePage hm=new HomePage(driver);
		hm.getContactsLink().click();
		
		/*Navigate to contacts page*/
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreatecontactsImg().click();
		
		/*Create contact*/ 
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.creatContact(contactName);
		//Assert.fail();
	}
}
