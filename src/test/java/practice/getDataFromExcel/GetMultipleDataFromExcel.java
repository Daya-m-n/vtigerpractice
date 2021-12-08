package practice.getDataFromExcel;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class GetMultipleDataFromExcel
{
	@Test
	public void GetMultipleData() throws Throwable
	{
		FileInputStream fin = new FileInputStream("./data/MultipleData.xlsx");
		Workbook workbook = WorkbookFactory.create(fin);
		Sheet sheet = workbook.getSheet("Sheet1");
		int rowNum = sheet.getLastRowNum();
		int cellNum = sheet.getRow(0).getLastCellNum();
		System.out.println(rowNum + " " + cellNum);

		for (int i = 0; i <= rowNum; i++)
		{
			for (int j = 0; j < cellNum; j++)
			{
				System.out.println(sheet.getRow(i).getCell(j).toString());
			}
		}
	}
}
