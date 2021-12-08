package practice.getDataFromExcel;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class GetDataFromExcelSheet4
{
	@Test
	public void getExcelData() throws Throwable
	{
		// Check the cell has value, if it is there fetch next cell value
		FileInputStream fin = new FileInputStream("./data/Book1.xlsx");
		Workbook workbook = WorkbookFactory.create(fin);
		Sheet sheet = workbook.getSheet("Sheet1");
		String expectedData = "admin";
		String actualData = sheet.getRow(1).getCell(2).toString();
		if (actualData.equals(expectedData))
		{
			System.out.println(sheet.getRow(1).getCell(3).toString());
		}

	}
}
