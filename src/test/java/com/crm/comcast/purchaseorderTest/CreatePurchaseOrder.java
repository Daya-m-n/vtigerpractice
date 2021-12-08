package com.crm.comcast.purchaseorderTest;

import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.objectrepositorylib.CreateNewProduct;
import com.crm.comcast.objectrepositorylib.CreateNewPurchaseOrderPage;
import com.crm.comcast.objectrepositorylib.CreateNewVendor;
import com.crm.comcast.objectrepositorylib.HomePage;
import com.crm.comcast.objectrepositorylib.ProductInformationPage;
import com.crm.comcast.objectrepositorylib.ProductsPage;
import com.crm.comcast.objectrepositorylib.PurchaseOrderInformationPage;
import com.crm.comcast.objectrepositorylib.PurchaseOrderPage;
import com.crm.comcast.objectrepositorylib.VendorInformationPage;
import com.crm.comcast.objectrepositorylib.VendorsPage;

public class CreatePurchaseOrder extends BaseClass
{
	@Test
	public void createPurchaseOrder() throws Throwable
	{
		/* Get the Random data */
		int randomNum = jLib.getRandomNumber();

		/* Get the test data From excel file */
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

		/* Navigate to product page */
		hPage.getProductsLink().click();

		/* Navigate to create new product page */
		ProductsPage pp = new ProductsPage(driver);
		pp.getCreateProductImg().click();

		/* create product */
		CreateNewProduct cnp = new CreateNewProduct(driver);
		cnp.createProduct(product);

		/* verification of product name */
		ProductInformationPage pip = new ProductInformationPage(driver);
		String actualProductName = pip.getProductSucMsg().getText();
		if (actualProductName.contains(product))
		{
			System.out.println(product + " product is created==PASS");
		} else
		{
			System.out.println(product + " product is not created==FAIL");
		}
		
		/*Navigate to Purchase order page*/
		hPage.clickPurchaseOrderLink();
		
		/*Navigate to create purchase order page*/
		PurchaseOrderPage pop=new PurchaseOrderPage(driver);
		pop.getCreatePurchaseOrderImg().click();
		
		/*create purchase order*/
		CreateNewPurchaseOrderPage cpo= new CreateNewPurchaseOrderPage(driver);
		cpo.createPurchaseOrder(subject, vendorName, adress, product, "10");
		
		/*verification*/
		PurchaseOrderInformationPage pinfo=new PurchaseOrderInformationPage(driver);
		String actualPurchaseOrder = pinfo.getPurchaseOrderSucMsg().getText();
		if (actualPurchaseOrder.contains(subject))
		{
			System.out.println(subject + " purchase order is created==PASS");
		} else
		{
			System.out.println(subject + " purchase order is not created==FAIL");
		}
	}
}
