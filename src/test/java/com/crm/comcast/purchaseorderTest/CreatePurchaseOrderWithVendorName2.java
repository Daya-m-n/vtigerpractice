package com.crm.comcast.purchaseorderTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.FileUtility;
import com.crm.comcast.genericutility.JavaUtility;
import com.crm.comcast.genericutility.WebDriverUtility;
import com.crm.comcast.objectrepositorylib.CreateNewPurchaseOrderPage;
import com.crm.comcast.objectrepositorylib.CreateNewVendor;
import com.crm.comcast.objectrepositorylib.HomePage;
import com.crm.comcast.objectrepositorylib.PurchaseOrderPage;
import com.crm.comcast.objectrepositorylib.VendorInformationPage;
import com.crm.comcast.objectrepositorylib.VendorsPage;

public class CreatePurchaseOrderWithVendorName2 extends BaseClass
{
	@Test
	public void createPurchaseOrderWithVendorName() throws Throwable {
		
		int	randomNum=jLib.getRandomNumber();
		
		String vendorName = eLib.getDataFromExcel("PurchaseOrder", 1, 2) + randomNum;
		String subject = eLib.getDataFromExcel("PurchaseOrder", 1, 3) + randomNum;
		String adress = eLib.getDataFromExcel("PurchaseOrder", 1, 4) + randomNum;
		String product = eLib.getDataFromExcel("PurchaseOrder", 1, 5) + randomNum;

		driver.manage().window().maximize();
		wLib.waitForPageToLoad(driver);
		
		/* Navigate to vendors page */
		HomePage hPage = new HomePage(driver);
		hPage.clickVendorsLink();

		/* Navigate to create vendors page */
		VendorsPage vp = new VendorsPage(driver);
		vp.getCreateVendorImg().click();

		/* create vendor */
		CreateNewVendor cnv = new CreateNewVendor(driver);
		cnv.createVendor(vendorName);

		/* verification of vendor name */
		VendorInformationPage vip = new VendorInformationPage(driver);
		String actualVendorName = vip.getVendorSucMsg().getText();
		if (actualVendorName.contains(vendorName))
		{
			System.out.println(vendorName + " vendor is created==PASS");
		} else
		{
			System.out.println(vendorName + " vendor is not created==FAIL");
		}
		
		/*Navigate to Purchase order page*/
		HomePage hP=new HomePage(driver);
		hP.clickPurchaseOrderLink();
		
		/*Navigate to create purchase order page*/
		PurchaseOrderPage pop=new PurchaseOrderPage(driver);
		pop.getCreatePurchaseOrderImg().click();
		
		/*select vendor from existing list*/
		CreateNewPurchaseOrderPage cnop=new CreateNewPurchaseOrderPage(driver);
		cnop.selectVendorFrmExistingList(vendorName);
	}
}
