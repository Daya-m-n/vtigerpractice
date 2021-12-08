package practice.getDataFromExcel;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.SDET25.GenericUtils.ExcelUtility;

public class FetchMultipleData
{ 

	@DataProvider
	public Object[][] data() throws Throwable
	{
		ExcelUtility eUtil = new ExcelUtility();
		return eUtil.getMultipleData();
	}

	@Test(dataProvider = "data")
	public void getData(String state, String capital)
	{
		System.out.println(state+"\t"+capital);
		
	}
}
