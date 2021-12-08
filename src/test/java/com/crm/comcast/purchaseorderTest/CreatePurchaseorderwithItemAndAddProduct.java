package com.crm.comcast.purchaseorderTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.objectrepositorylib.CreateNewPurchaseOrderPage;
import com.crm.comcast.objectrepositorylib.HomePage;
import com.crm.comcast.objectrepositorylib.PurchaseOrderPage;

public class CreatePurchaseorderwithItemAndAddProduct extends BaseClass
{
	@Test
	public void createPurchaseOrder() throws Throwable
	{
		/* Get the test data From excel file */
		String product = eLib.getDataFromExcel("PurchaseOrder", 1, 5);

		driver.manage().window().maximize();
		wLib.waitForPageToLoad(driver);

		/* Select purchase order */
		HomePage hPage = new HomePage(driver);
		hPage.clickPurchaseOrderLink();

		/* Navigate to create purchase order page */
		PurchaseOrderPage pop = new PurchaseOrderPage(driver);
		pop.getCreatePurchaseOrderImg().click();

		CreateNewPurchaseOrderPage cnop = new CreateNewPurchaseOrderPage(driver);
		cnop.selectProductFrmExistingList(product);
		/* Verification */
		WebElement ele = driver.findElement(By.id("productName1"));
		String itemName = ele.getAttribute("value");
		if (itemName.equals(product))
		{
			System.out.println(product + " is selected:PASS");
		} else
		{
			System.out.println(product + " is not selected:FAIL");
		}

	}
}
