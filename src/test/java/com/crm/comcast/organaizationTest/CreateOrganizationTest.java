package com.crm.comcast.organaizationTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.objectrepositorylib.CreateNewOrganizationPage;
import com.crm.comcast.objectrepositorylib.HomePage;
import com.crm.comcast.objectrepositorylib.OrganizationInformationPage;
import com.crm.comcast.objectrepositorylib.OrganizationsPage;

public class CreateOrganizationTest extends BaseClass
{
	@Test(groups="Smoke")
	public void createOrganizationTest() throws Throwable
	{
	
		/* Get the random number */
		int randomNum = jLib.getRandomNumber();

		/* Read data from excel file */
		
		String orgName = eLib.getDataFromExcel("Organization", 1, 2) + randomNum;
		

		/* Navigate to the organization */
		HomePage hPage = new HomePage(driver);
		hPage.getOrganizationLink().click();

		/* Navigate to the create organization */
		OrganizationsPage orgPage = new OrganizationsPage(driver);
		orgPage.getCreateOrgImg().click();

		/* Create organization */
		CreateNewOrganizationPage createOrg = new CreateNewOrganizationPage(driver);
		createOrg.createOrganization(orgName);

		/* Verification */
		OrganizationInformationPage orgInfo = new OrganizationInformationPage(driver);
		String actSucMsg = orgInfo.getSuccesfulMsg().getText();
		//String actSucMsg = "ddvheehhdhdevhedh";
		Boolean	status=actSucMsg.contains(orgName);
		Assert.assertTrue(status,"Organization not created== FAIL");
		

	}

	@Test(groups = "Regression")

	public void createOrganizationWithIndustryTypeTest() throws Throwable
	{

		/* Get the random number */
		int randomNum = jLib.getRandomNumber();

		/* Read data from excel file */
		String orgName = eLib.getDataFromExcel("Organization", 1, 2) + randomNum;
		String indusrty = eLib.getDataFromExcel("Organization", 3, 3);
		String indusrtyType = eLib.getDataFromExcel("Organization", 3, 4);

		/* Launch the browser */
		wLib.waitForPageToLoad(driver);
		driver.manage().window().maximize();

		/* Navigate to the organization */
		HomePage hPage = new HomePage(driver);
		hPage.getOrganizationLink().click();

		/* Navigate to the create organization */
		OrganizationsPage orgPage = new OrganizationsPage(driver);
		orgPage.getCreateOrgImg().click();

		/* Create organization */
		CreateNewOrganizationPage createOrg = new CreateNewOrganizationPage(driver);
		createOrg.createOrganization(orgName, indusrty, indusrtyType);

		/* Verification */
		OrganizationInformationPage orgInfo = new OrganizationInformationPage(driver);
		String actSucMsg = orgInfo.getSuccesfulMsg().getText();
		boolean status=actSucMsg.contains(orgName);
		Assert.assertTrue(status,"Organization not Created== FAIL");
		
		/* Verification of industry */
		String actInduystry = orgInfo.getIndustrySucInfo().getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actInduystry, indusrty, "Industry not verified == FAIL");
		

		/* Verification of industry type */
		String actInduystryType = orgInfo.getIndustryTypeSucInfo().getText();
		soft.assertEquals(actInduystryType, indusrtyType, "Organization type not verified == FAIL");
		soft.assertAll();
	}
}
