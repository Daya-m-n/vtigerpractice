package practice.getDataFromExcel;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class GetDataFromExcelSheet3
{
	@Test
	public void getExcelData() throws Throwable
	{
		// Fetch only 1st and 2nd column data from all the rows
		FileInputStream fin = new FileInputStream("./data/Book1.xlsx");
		Workbook workbook = WorkbookFactory.create(fin);
		Sheet sheet = workbook.getSheet("Sheet1");
		int rowNum = sheet.getLastRowNum();

 		for (int i = 0; i <= rowNum; i++)
		{
			Row row = sheet.getRow(i);
			System.out.println(row.getCell(0).getStringCellValue());
			System.out.println(row.getCell(1).getStringCellValue());

		}

		/*
		 * for (int i = 0; i <= rowNum; i++) { Row row = sheet.getRow(i); for (int j =
		 * 0; j <= 4; j++) { System.out.println(row.getCell(j).toString()); }
		 * 
		 * }
		 */

	}
}
