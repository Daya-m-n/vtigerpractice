package com.crm.comcast.contactTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.objectrepositorylib.ContactInformationPage;
import com.crm.comcast.objectrepositorylib.ContactsPage;
import com.crm.comcast.objectrepositorylib.CreateNewContactPage;
import com.crm.comcast.objectrepositorylib.CreateNewOrganizationPage;
import com.crm.comcast.objectrepositorylib.HomePage;
import com.crm.comcast.objectrepositorylib.OrganizationInformationPage;
import com.crm.comcast.objectrepositorylib.OrganizationsPage;

/**
 * To create contact with last name
 * 
 * @author Dayananda M N
 *
 */
public class CreateContactTest extends BaseClass
{
	@Test(groups="Smoke")
	public void createContactTest() throws Throwable
	{

		/* Get random data */
		int randomNum = jLib.getRandomNumber();

		/* Read data from excel file */
		String contactName = eLib.getDataFromExcel("Contact", 1, 2) + "_" + randomNum;

		driver.manage().window().maximize();
		wLib.waitForPageToLoad(driver);

		/* Step1: Navigate to the contacts page */
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();

		/* Navigate to the create contacts page */
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreatecontactsImg().click();

		/* Create contact */
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.creatContact(contactName);

		/* Verification */
		ContactInformationPage cip = new ContactInformationPage(driver);
		String actualContactName = cip.getSuccessfulMsg().getText();
		boolean	status=actualContactName.contains(contactName);
		Assert.assertTrue(status,"Contact Not Created == FAIL");

	}
	
	@Test(groups="Regression")
	public void createConatctWithOrgnizationTest() throws Throwable
	{
		/* Get the random number */
		int randomNum = jLib.getRandomNumber();

		/* Read data from excel file */
		ExcelUtility eLib = new ExcelUtility();
		String orgName = eLib.getDataFromExcel("Organization", 1, 2) + randomNum;
		String contactName = eLib.getDataFromExcel("Contact", 1, 2) + randomNum;

		/* Navigate to the organization */
		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();

		/* Navigate to the create organization */
		OrganizationsPage orgPage = new OrganizationsPage(driver);
		orgPage.getCreateOrgImg().click();

		/* Create organization */
		CreateNewOrganizationPage createOrg = new CreateNewOrganizationPage(driver);
		createOrg.createOrganization(orgName);

		/* Verification */
		OrganizationInformationPage orgInfo = new OrganizationInformationPage(driver);
		String actSucMsg = orgInfo.getSuccesfulMsg().getText();
		boolean orgStatus = actSucMsg.contains(orgName);
		Assert.assertTrue(orgStatus,"Organization not created === FAIL");
		

		/* Step1: Navigate to the contacts page */
		
		hp.getContactsLink().click();

		/* Navigate to the create contacts page */
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreatecontactsImg().click();

		/* Create contact */
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.creatContact(contactName,orgName);

		/* Verification */
		ContactInformationPage cip = new ContactInformationPage(driver);
		String actualContactName = cip.getSuccessfulMsg().getText();
		boolean contactStatus = actualContactName.contains(contactName);
		Assert.assertTrue(contactStatus,"Contact not created");
		

	}
	
	@Test(groups="Regression")
	public void createContactWithSupportDateTest() throws Throwable
	{

		/* Get random data */
		int randomNum = jLib.getRandomNumber();

		/* Read data from excel file */
		String contactName = eLib.getDataFromExcel("Contact", 1, 2) + "_" + randomNum;
		String mobileNumber = eLib.getDataFromExcel("Contact", 3, 3);

		driver.manage().window().maximize();
		wLib.waitForPageToLoad(driver);

		/* Step1: Navigate to the contacts page */
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();

		/* Navigate to the create contacts page */
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreatecontactsImg().click();

		/* Create contact */
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.creatContact(contactName, mobileNumber, jLib.getSystemDateFormat());

		/* Verification */
		ContactInformationPage cip = new ContactInformationPage(driver);
		String actualContactName = cip.getSuccessfulMsg().getText();
		boolean contactStatus = actualContactName.contains(contactName);
		Assert.assertTrue(contactStatus, "Contact not created");
		
		/* Verification */

		String actualMobileNum = cip.getMobileNoSucInfo().getText();
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(actualMobileNum, mobileNumber,"Mobile number not verified == FAIL");
		

		/* Verification */
		String actualDateEntered = cip.getSupportDateSucInfo().getText();
		softAssert.assertEquals(actualDateEntered, jLib.getSystemDateFormat());
		System.out.println("Date verified-------");
		softAssert.assertAll();

	}
}
