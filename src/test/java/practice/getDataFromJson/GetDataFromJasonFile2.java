package practice.getDataFromJson;

import org.testng.annotations.Test;

import com.crm.SDET25.GenericUtils.FileUtility;

public class GetDataFromJasonFile2
{
	@Test
	public void getDataJason() throws Throwable
	{
		FileUtility futil=new FileUtility();
		System.out.println(futil.readDataFromJsonFile("url"));
	}
}
