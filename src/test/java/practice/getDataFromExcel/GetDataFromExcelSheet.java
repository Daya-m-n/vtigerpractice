package practice.getDataFromExcel;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class GetDataFromExcelSheet
{
	@Test
	public void getExcelData() throws Throwable
	{
		//Fetching data from single cell
		FileInputStream fin = new FileInputStream("./data/Book1.xlsx");
 		Workbook workbook = WorkbookFactory.create(fin);
		Sheet sheet = workbook.getSheet("Sheet1");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(0);
		String url = cell.getStringCellValue();
		System.out.println(url);

	}
}
