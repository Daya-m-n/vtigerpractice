package com.crm.comcast.purchaseorderTest;

import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.objectrepositorylib.CreateNewPurchaseOrderPage;
import com.crm.comcast.objectrepositorylib.HomePage;
import com.crm.comcast.objectrepositorylib.PurchaseOrderPage;

public class CreatePurchaseOrderWithVendorName extends BaseClass
{
	@Test
	public void createPurchaseOrderWithVendorName() throws Throwable {

		String vendorName =eLib.getDataFromExcel("PurchaseOrder", 1, 2);

		driver.manage().window().maximize();
		wLib.waitForPageToLoad(driver);
		
		/*Navigate to Purchase order page*/
		HomePage hPage=new HomePage(driver);
		hPage.clickPurchaseOrderLink();
		
		/*Navigate to create purchase order page*/
		PurchaseOrderPage pop=new PurchaseOrderPage(driver);
		pop.getCreatePurchaseOrderImg().click();
		
		/*select vendor from existing list*/
		CreateNewPurchaseOrderPage cnop=new CreateNewPurchaseOrderPage(driver);
		cnop.selectVendorFrmExistingList(vendorName);
		
		
		/*verification*/
		String actualVendorName = cnop.getVendorSelectedConfMsg().getAttribute("value");
		System.out.println(actualVendorName);
		if (actualVendorName.equals(vendorName))
		{
			System.out.println("Vendor is selected successfully");
		} else
		{
			System.out.println("Vendor is not selected ");
		}
	}
}
