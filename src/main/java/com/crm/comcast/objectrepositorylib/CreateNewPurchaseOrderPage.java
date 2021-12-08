package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebDriverUtility;

public class CreateNewPurchaseOrderPage extends WebDriverUtility
{
	WebDriver driver;

	public CreateNewPurchaseOrderPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "subject")
	private WebElement subjectNameEdt;

	@FindBy(xpath = "//input[@name='vendor_id']/following-sibling::img")
	private WebElement vendorLookupIcon;

	@FindBy(name = "bill_street")
	private WebElement billingAdressEdt;

	@FindBy(xpath = "//input[@onclick='return copyAddressRight(EditView)']")
	private WebElement copyBillingAdresssRadioBtn;

	@FindBy(id = "searchIcon1")
	private WebElement productLookUpImg;

	@FindBy(id = "qty1")
	private WebElement productQty;

	@FindBy(xpath = "//textarea[@name='description']/following::input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(name = "vendor_name")
	private WebElement vendorSelectedConfMsg;

	public WebElement getVendorSelectedConfMsg()
	{
		return vendorSelectedConfMsg;
	}

	public WebElement getSaveButton()
	{
		return saveButton;
	}

	public WebElement getProductQty()
	{
		return productQty;
	}

	public WebElement getSubjectNameEdt()
	{
		return subjectNameEdt;
	}

	public WebElement getVendorLookupIcon()
	{
		return vendorLookupIcon;
	}

	public WebElement getBillingAdressEdt()
	{
		return billingAdressEdt;
	}

	public WebElement getCopyBillingAdresssRadioBtn()
	{
		return copyBillingAdresssRadioBtn;
	}

	public WebElement getProductLookUpImg()
	{
		return productLookUpImg;
	}

	public void createPurchaseOrder(String subject, String vendorName, String billingAdress, String productName,
			String productQuantity)
	{
		subjectNameEdt.sendKeys(subject);
		vendorLookupIcon.click();
		switchToWindow(driver, "Vendors");
		VendorsPage vp = new VendorsPage(driver);
		vp.getVendorSearchBox().sendKeys(vendorName);
		vp.getVendorSearchButton().click();
		driver.findElement(By.xpath("//a[text()='" + vendorName + "']")).click();
		switchToWindow(driver, "Purchase Order");
		billingAdressEdt.sendKeys(billingAdress);
		copyBillingAdresssRadioBtn.click();
		productLookUpImg.click();
		switchToWindow(driver, "Products");
		ProductsPage pp = new ProductsPage(driver);
		pp.getProductSearchBox().sendKeys(productName);
		pp.getProductSearchButton().click();
		driver.findElement(By.xpath("//a[text()='" + productName + "']")).click();
		switchToWindow(driver, "Purchase Order");
		productQty.sendKeys(productQuantity);
		saveButton.click();
	}

	public void selectVendorFrmExistingList(String vendorName)
	{
		vendorLookupIcon.click();
		switchToWindow(driver, "Vendors");
		VendorsPage vp = new VendorsPage(driver);
		vp.getVendorSearchBox().sendKeys(vendorName);
		vp.getVendorSearchButton().click();
		driver.findElement(By.xpath("//a[text()='" + vendorName + "']")).click();
		switchToWindow(driver, "Purchase Order");
	}
	
	public void selectProductFrmExistingList(String productName)
	{
		productLookUpImg.click();
		switchToWindow(driver, "Products");
		ProductsPage pp = new ProductsPage(driver);
		pp.getProductSearchBox().sendKeys(productName);
		pp.getProductSearchButton().click();
		driver.findElement(By.xpath("//a[text()='" + productName + "']")).click();
		switchToWindow(driver, "Purchase Order");
	}
}
